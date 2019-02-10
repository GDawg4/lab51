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

    fun onClickRetrieveStudents(view:View) {
        // Retrieve student records
        val URL = "content://com.example.garoz.ContactProvider"

        val students = Uri.parse(URL)

        val c = contentResolver.query(students, null, null, null, "name")


        if (c.moveToFirst()) {
            do {
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(ContactProvider._ID)) +
                                ", " + c.getString(c.getColumnIndex(ContactProvider.NAME))
                                //", " + c.getString(c.getColumnIndex(ContactProvider.PHONE)) +
                                //", " + c.getString(c.getColumnIndex(ContactProvider.EMAIL))
                                ,
                        Toast.LENGTH_SHORT).show()
            } while (c.moveToNext())
        }
        c.close();
    }
}
