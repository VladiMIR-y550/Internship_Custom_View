package com.mironenko.internship_custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RectangleCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private var rectCornerRadius = 0f
    private var borderLineSize = 0f

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.BLACK
        style = Paint.Style.STROKE
    }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RectangleCustomView,
            0,
            0
        ).apply {
            try {
                setRectCornerRadius(
                    getDimension(
                        R.styleable.RectangleCustomView_rectCornerRadius,
                        0f
                    )
                )
                setBorderLineSize(
                    getDimension(
                        R.styleable.RectangleCustomView_borderLineSize,
                        0f
                    )
                )
                setBorderLineColor(
                    getColor(
                        R.styleable.RectangleCustomView_borderLineColor,
                        -1
                    )
                )
            } finally {
                recycle()
            }
        }
    }

    private fun setRectCornerRadius(radius: Float) {
        rectCornerRadius = radius
        notifyView()
    }

    private fun setBorderLineSize(lineSize: Float) {
        paint.strokeWidth = lineSize
        borderLineSize = lineSize
        notifyView()
    }

    private fun setBorderLineColor(lineColor: Int) {
        paint.color = lineColor
        notifyView()
    }

    private fun notifyView() {
        invalidate()
        requestLayout()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.apply {
            drawRoundRect(
                borderLineSize / 2,
                borderLineSize / 2,
                width - borderLineSize / 2,
                height - borderLineSize / 2,
                rectCornerRadius,
                rectCornerRadius,
                paint
            )
        }
    }
}