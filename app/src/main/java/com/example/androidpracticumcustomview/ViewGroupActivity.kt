package com.example.androidpracticumcustomview

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity.CENTER_HORIZONTAL
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.util.TypedValueCompat.dpToPx
import androidx.core.util.TypedValueCompat.spToPx
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpracticumcustomview.ui.theme.CustomContainer

class ViewGroupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startXmlPracticum()
    }

    private fun startXmlPracticum() {
        val customContainer = CustomContainer(this)
        setContentView(customContainer)

        val metrics = Resources.getSystem().displayMetrics

        val firstView = TextView(this).apply {
            text = "First Child"
            setTextColor(Color.BLACK)
            setPadding(
                dpToPx(16f,metrics).toInt(),
                dpToPx(16f,metrics).toInt(),
                dpToPx(16f,metrics).toInt(),
                dpToPx(16f,metrics).toInt())
            textSize = spToPx(16f,metrics)
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
        }

        val secondView = TextView(this).apply {
            text = "Second Child"
            setTextColor(Color.BLACK)
            setPadding(
                dpToPx(16f,metrics).toInt(),
                dpToPx(16f,metrics).toInt(),
                dpToPx(16f,metrics).toInt(),
                dpToPx(16f,metrics).toInt()
            )
            textSize = spToPx(16f,metrics)
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
        }

        customContainer.addView(firstView)

        // Добавление второго элемента через некоторое время
        Handler(Looper.getMainLooper()).postDelayed({
            customContainer.addView(secondView)
        }, 2000)
    }
}