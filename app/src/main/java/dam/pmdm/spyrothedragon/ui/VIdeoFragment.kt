package dam.pmdm.spyrothedragon.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dam.pmdm.spyrothedragon.R
import dam.pmdm.spyrothedragon.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Inflamos el layout usando el binding
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Accedemos al VideoView directamente a través del binding
        val videoView = binding.videoView

        // Preparamos la ruta del vídeo
        val videoPath = "android.resource://${requireContext().packageName}/${R.raw.spyro_video}"
        videoView.setVideoURI(Uri.parse(videoPath))

        // Al finalizar el vídeo, volvemos a la pestaña de mundos
        videoView.setOnCompletionListener {
            findNavController().popBackStack()
        }

        // Iniciamos la reproducción
        videoView.start()
    }

    //Liberamos el binding al destruir la vista
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}