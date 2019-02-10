package com.example.garoz.lab51

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import android.content.ContentValues
import android.net.Uri
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickAddName(view: View) {
        // Add a new student record
        val values = ContentValues()
        values.put(ContactProvider.NAME, editText2.text.toString())

        values.put(ContactProvider.EMAIL, editText3.text.toString())

        val uri = contentResolver.insert(ContactProvider.CONTENT_URI, values)

        Toast.makeText(baseContext, uri!!.toString(), Toast.LENGTH_LONG).show()
    }
}
