package com.example.sahdowlayout.views

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.sahdowlayout.R
import com.example.sahdowlayout.Shadow

class ShadowButton : androidx.appcompat.widget.AppCompatButton {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val ta: TypedArray? = context?.obtainStyledAttributes(attrs, R.styleable.ShadowTextView)
        val shadowColor = ta?.getColor(R.styleable.ShadowTextView_shadowColor, ContextCompat.getColor(context, R.color.default_shadow_color))
        val shadowRadius = ta?.getInt(R.styleable.ShadowTextView_shadow_radius, 10)
        val shadowAlpha = ta?.getInt(R.styleable.ShadowTextView_shadow_alpha, 90)
        val shadowXOffset = ta?.getInt(R.styleable.ShadowTextView_shadow_x_offset, 10)
        val shadowYOffset = ta?.getInt(R.styleable.ShadowTextView_shadow_y_offset, 10)

        val shadow = Shadow()
        shadow.alpha = shadowAlpha ?: 90
        shadow.blur = shadowRadius ?: 10
        shadow.color = shadowColor ?: ContextCompat.getColor(context
                ?: return, R.color.default_shadow_color)
        shadow.x = shadowXOffset ?: 0
        shadow.y = shadowYOffset ?: 0


        this.setTag(R.id.shadow, shadow)
        ta?.recycle()
    }

}