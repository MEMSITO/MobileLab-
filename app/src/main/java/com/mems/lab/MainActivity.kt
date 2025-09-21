package com.mems.lab

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val mainMethods = MainMethods()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textInput : TextInputEditText = findViewById(R.id.textInput)
        val enterButton : Button =  findViewById(R.id.enterButton)
        val textView : TextView =  findViewById(R.id.textViewCountOfEachWord)
        fun printTo(){
            textView.text = mainMethods.printTo()
        }
        enterButton.setOnClickListener {
            var text = textInput.text.toString()
            printTo()
            if (text.isNotBlank()) {
                mainMethods.addText(text)
                printTo()
                mainMethods.clearStats()
            }

        }
    }
}