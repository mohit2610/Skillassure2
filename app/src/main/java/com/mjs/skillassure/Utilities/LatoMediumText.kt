package com.mjs.skillassure.Utilities

import android.content.Context
import android.graphics.Canvas
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.Typeface
import android.util.AttributeSet

class LatoMediumText : AppCompatTextView {
    constructor(context: Context) : super(context) {
        val face = Typeface.createFromAsset(context.assets, "lato_medium.ttf")
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val face = Typeface.createFromAsset(context.assets, "lato_medium.ttf")
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        val face = Typeface.createFromAsset(context.assets, "lato_medium.ttf")
        this.typeface = face
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}