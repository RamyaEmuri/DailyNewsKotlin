package com.example.dailynewskotlin.widgets

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.widget.EditText
import com.example.dailynewskotlin.R

class MyEditText : EditText {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        if (!isInEditMode)
            initWithAttrs(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        if (!isInEditMode)
            initWithAttrs(context, attrs, defStyleAttr)
    }

    private fun initWithAttrs(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.MyTextView, defStyleAttr, 0)
        val customFontIndex = a.getInt(R.styleable.MyTextView_setFont, -1)
        if (customFontIndex != -1) {
            val fontPath = resources.getStringArray(R.array.FontNames)[customFontIndex]
            setCustomFont(fontPath)
        }

        a.recycle()
    }

    /**
     * Loads a font from the given asset path
     *
     * @param customFontPath path in the assets folder to the font file
     */
    private fun setCustomFont(customFontPath: String) {
        if (isInEditMode && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1) {
            //in the Android Studio stf_template preview, with SDK < 22, this throws an exception.  You'll
            // only see your custom font in the preview if you have the SDK set to 22 or above.
            return
        }
        val typeface = Typeface.createFromAsset(context.assets, "fonts/$customFontPath")
        setTypeface(typeface)
        setPadding(0,0,0,0)
        includeFontPadding = false
    }
}

