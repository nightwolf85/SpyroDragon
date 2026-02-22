package dam.pmdm.spyrothedragon.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dam.pmdm.spyrothedragon.R
import dam.pmdm.spyrothedragon.databinding.FragmentGuiaPantalla4Binding

class GuiaPantalla4Fragment : Fragment() {

    // Usamos el sistema de "Binding" igual que en los fragments ya existentes en la app.
    private var _binding: FragmentGuiaPantalla4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflamos el layout de la pantalla 4 de la guía
        _binding = FragmentGuiaPantalla4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Cargamos la animación definida en el fichero aparecer_bocadillo.xml
        val animacion = AnimationUtils.loadAnimation(requireContext(), R.anim.aparecer_bocadillo)

        //Aplicamos la animación al bocadillo
        binding.bocadillo.startAnimation(animacion)

        // AVANCE EN LA GUÍA (Apartado B - Punto 1)
        binding.btnSiguiente.setOnClickListener {
            //Se reproduce el sonido la pulsar el botón
            reproducirSonido(requireContext(), R.raw.spyro_gem)
            // "action_guia4_to_guia5" es el ID de la flecha en el nav_graph para pasar a la siguiente pantalla de la guía
            findNavController().navigate(R.id.action_guia4_to_guia5)
        }

        // OMITIR LA GUÍA (Apartado B - Punto 2)
        binding.btnOmitir.setOnClickListener {
            //Se reproduce el sonido la pulsar el botón para otitir la guía
            reproducirSonido(requireContext(), R.raw.spyro_egg_thief)
            finalizarGuia()
        }
    }

    private fun finalizarGuia() {
        // Navegamos al fragment principal de la app (el que ya venía creado)
        findNavController().navigate(R.id.navigation_characters)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}