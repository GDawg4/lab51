package com.example.garoz.lab51

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class OneContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val name = intent.getStringExtra("name")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_contact)

        val nameOnScreen = findViewById<TextView>(R.id.contactName)
        nameOnScreen.text = name
    }
}
