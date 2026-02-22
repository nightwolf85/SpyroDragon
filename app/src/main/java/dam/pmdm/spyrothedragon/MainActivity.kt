package dam.pmdm.spyrothedragon

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment: Fragment? =
            supportFragmentManager.findFragmentById(R.id.navHostFragment)

        navHostFragment?.let {
            navController = NavHostFragment.findNavController(it)
            NavigationUI.setupWithNavController(binding.navView, navController!!)
            NavigationUI.setupActionBarWithNavController(this, navController!!)
        }

        // Comprobamos si la guía ya se ha completado antes
        val prefs = getSharedPreferences("GuiaPrefs", Context.MODE_PRIVATE)
        val completada = prefs.getBoolean("completada", false)

        if (!completada) {
            // Si no está completada, navegamos inmediatamente al fragmento de bienvenida
            navController?.navigate(R.id.navigation_bienvenida)
        }

        binding.navView.setOnItemSelectedListener { menuItem ->
            selectedBottomMenu(menuItem)
        }

        navController?.addOnDestinationChangedListener { _, destination, _ ->
            // Si estamos en la pantalla de bienvenida o en la última de la guía, ocultamos el menú inferior y la barra superior
            if (destination.id == R.id.navigation_bienvenida || destination.id == R.id.navigation_pantalla_6) {

                binding.navView.visibility = View.GONE // Oculta el menú de abajo
                supportActionBar?.hide() // Oculta la barra de arriba
            } else {
                binding.navView.visibility = View.VISIBLE // Lo vuelve a mostrar en la app normal
                supportActionBar?.show()
                when (destination.id) {
                    R.id.navigation_characters,
                    R.id.navigation_worlds,
                    R.id.navigation_collectibles -> {
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    }
                    else -> supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }
        }
    }

    private fun selectedBottomMenu(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_characters ->
                navController?.navigate(R.id.navigation_characters)
            R.id.nav_worlds ->
                navController?.navigate(R.id.navigation_worlds)
            else ->
                navController?.navigate(R.id.navigation_collectibles)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_info) {
            showInfoDialog()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun showInfoDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.title_about)
            .setMessage(R.string.text_about)
            .setPositiveButton(R.string.accept, null)
            .show()
    }
}
