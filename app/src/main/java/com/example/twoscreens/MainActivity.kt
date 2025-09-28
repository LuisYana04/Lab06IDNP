package com.example.twoscreens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.inputText)
        val send = findViewById<Button>(R.id.btnSend)

        send.setOnClickListener {
            val msg = input.text.toString()
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("message", msg)
            startActivity(i)
        }
    }
}
