package com.example.sahdowlayout

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.renderscript.Allocation
import androidx.renderscript.Element
import androidx.renderscript.RenderScript
import androidx.renderscript.ScriptIntrinsicBlur

class ShadowLayout : FrameLayout {


    private var result: Bitmap? = null
    internal var paint = Paint()
    internal var rsScript: RenderScript? = null
    internal var metrics = resources.displayMetrics

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private fun dp(px: Int): Int {
        val density = resources.displayMetrics.density
        return (px * density).toInt()
    }

    private fun sp(px: Int): Int {
        val density = resources.displayMetrics.scaledDensity
        return (px * density).toInt()
    }


    override fun drawChild(canvas: Canvas, child: View, drawingTime: Long): Boolean {
        val shadow = child.getTag(R.id.shadow)

        if (shadow is Shadow) {
            if (rsScript == null) {
                rsScript = RenderScript.create(context)
            }
            val width = child.measuredWidth.toFloat()
            val height = child.measuredHeight.toFloat()
            val input = Bitmap.createBitmap((width + dp(shadow.x) + dp(shadow.blur * 2)).toInt(), (height + dp(shadow.y) + dp(shadow.blur * 2)).toInt(), Bitmap.Config.ARGB_8888)
            val filter = PorterDuffColorFilter(Color.parseColor(shadow.color), PorterDuff.Mode.SRC_IN)
            paint.colorFilter = filter
            val canvasBitmap = Canvas(input)
            canvasBitmap.save()
            canvasBitmap.translate(dp(shadow.x).toFloat() + dp(shadow.blur), dp(shadow.y).toFloat() + dp(shadow.blur))
            child.draw(canvasBitmap)
            canvasBitmap.restore()
            canvasBitmap.drawBitmap(input, 0f, 0f, paint)
            val alloc = Allocation.createFromBitmap(rsScript!!, input)
            val blur = ScriptIntrinsicBlur.create(rsScript!!, Element.U8_4(rsScript!!))
            if (shadow.blur > 25) {
                shadow.blur = 25
            } else if (shadow.blur < 0) {
                shadow.blur = 0
            }
            blur.setRadius(shadow.blur.toFloat())
            blur.setInput(alloc)
            result = Bitmap.createBitmap(input.width, input.height, Bitmap.Config.ARGB_8888)
            val outAlloc = Allocation.createFromBitmap(rsScript!!, result!!)
            blur.forEach(outAlloc)
            outAlloc.copyTo(result!!)
            canvas.drawBitmap(result!!, child.x - dp(shadow.blur), child.y - dp(shadow.blur), paint)

        }
        return super.drawChild(canvas, child, drawingTime)

    }

    override fun onDetachedFromWindow() {
        rsScript?.destroy()
        rsScript = null
        super.onDetachedFromWindow()
    }
}
