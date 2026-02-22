package dam.pmdm.spyrothedragon.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import dam.pmdm.spyrothedragon.R

class DiamanteRiptoAnim @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var radio = 0f
    private val paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.red) // Color mágico
        style = Paint.Style.FILL
        // Filtro de desenfoque para efecto resplandor
        maskFilter = BlurMaskFilter(25f, BlurMaskFilter.Blur.NORMAL)
    }

    fun iniciarBrillo() {
        val animator = ValueAnimator.ofFloat(0f, 80f)
        animator.duration = 1500
        animator.addUpdateListener {
            radio = it.animatedValue as Float
            invalidate() // Fuerza el redibujado
        }
        animator.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Dibujamos el círculo que representa la energía del diamante
        canvas.drawCircle(width / 2f, height / 2f, radio, paint)
    }
}