package dam.pmdm.spyrothedragon.ui

import android.content.Context
import android.media.MediaPlayer

//Función para reproducir los sonidos en la guía, tanto para la bienvenida, pulsar en siguiente, omitir o finalizar.
fun reproducirSonido(requireContext: Context, sonidoId: Int) {
    val mp = MediaPlayer.create(requireContext, sonidoId)
    mp.setOnCompletionListener { it.release() }
    mp.start()
}