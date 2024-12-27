package com.example.androidpracticumcustomview

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity.CENTER_HORIZONTAL
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidpracticumcustomview.ui.theme.CustomContainer
import com.example.androidpracticumcustomview.ui.theme.MainScreen

/*
Задание:
Реализуйте необходимые компоненты.
*/

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonViewGroup = findViewById<Button>(R.id.button_to_viewGroup)
        val buttonCompose = findViewById<Button>(R.id.button_to_Compose)

        buttonViewGroup.setOnClickListener {
            val intent = Intent(this, ViewGroupActivity::class.java)
            startActivity(intent)
        }
        buttonCompose.setOnClickListener {
            val intent = Intent(this, ComposeActivity::class.java)
            startActivity(intent)
        }

    }
}