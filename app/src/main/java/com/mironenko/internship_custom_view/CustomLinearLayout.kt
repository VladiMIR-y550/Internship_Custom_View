package com.mironenko.internship_custom_view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.setPadding

class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var itemTextSize = 0f
    private var itemTextPadding = 0f
    private var itemTextColor = -1
    private var itemTextBackgroundColor = -1

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomLinearLayout,
            0,
            0
        ).apply {
            try {
                itemTextColor = getColor(
                    R.styleable.CustomLinearLayout_itemTextColor,
                    getColor(context, R.color.item_text_view)
                )
                itemTextBackgroundColor = getColor(
                    R.styleable.CustomLinearLayout_itemTextBackground,
                    getColor(context, R.color.item_text_view_background)
                )
                itemTextSize = getDimension(
                    R.styleable.CustomLinearLayout_itemTextSize,
                    R.dimen.itemTextSize.toFloat()
                )
                itemTextPadding = getDimension(
                    R.styleable.CustomLinearLayout_itemTextPadding,
                    R.dimen.itemTextViewPadding.toFloat()
                )
            } finally {
                recycle()
            }
        }
    }

    fun addItem(item: String) {
        addView(createItem(item))
    }

    private fun createItem(textItem: String): TextView {
        return TextView(context).apply {
            text = textItem
            textSize = itemTextSize
            setTextColor(itemTextColor)
            setBackgroundColor(itemTextBackgroundColor)
            setPadding(itemTextPadding.toInt())
        }
    }
}