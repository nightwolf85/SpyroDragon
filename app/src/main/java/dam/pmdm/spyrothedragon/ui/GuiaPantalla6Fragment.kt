package dam.pmdm.spyrothedragon.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dam.pmdm.spyrothedragon.R
import dam.pmdm.spyrothedragon.databinding.FragmentGuiaPantalla6Binding
import androidx.core.content.edit

class GuiaPantalla6Fragment : Fragment() {

    // Usamos el sistema de "Binding" igual que en los fragments ya existentes en la app.
    private var _binding: FragmentGuiaPantalla6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflamos el layout de la pantalla 6 de la guía
        _binding = FragmentGuiaPantalla6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // AVANCE EN LA GUÍA (Apartado B - Punto 1)
        binding.btnFinalizar.setOnClickListener {
            //Se reproduce el sonido la pulsar el botón
            reproducirSonido(requireContext(), R.raw.spyro_gem)
            //Se indica que la guía ya se ha completado para no mostrarla al cerrar y volver a abrir la aplicación.
            val prefs = requireActivity().getSharedPreferences("GuiaPrefs", Context.MODE_PRIVATE)
            prefs.edit { putBoolean("completada", true) }

            // Volvemos a la pantalla inicial
            findNavController().navigate(R.id.navigation_characters)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}