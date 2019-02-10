package com.example.garoz.lab51

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.content.ContentValues
import android.widget.Toast
import com.example.garoz.lab51.R.string.students

class AllContactsActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    fun getAllContacts():ArrayList<String>{
        // Retrieve student records
        val URL = "content://com.example.garoz.ContactProvider"

        val students = Uri.parse(URL)
        val c = contentResolver.query(students, null, null, null, "name")

        val testList = ArrayList<String>()
        if (c.moveToFirst()) {
            do {
                testList.add(c.getString(c.getColumnIndex(ContactProvider.NAME)))
            } while (c.moveToNext())
        }
        c.close()
        listView.invalidateViews()
        return testList
    }

    fun addContact(view:View){
        listView.invalidateViews()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_contacts)

        listView = findViewById(R.id.contactList)
        listView.adapter = ContactsAdapter(this, getAllContacts())

        listView.setOnItemClickListener { _, _, position, _ ->

            val URL = "content://com.example.garoz.ContactProvider"

            val students = Uri.parse(URL)

            val c = contentResolver.query(students, null, null, null, "name")

            c.moveToPosition(position)
            val name = c.getString(c.getColumnIndex(ContactProvider.NAME))

            c.close()

            var intent = Intent(this, OneContactActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }

    override fun onResume() {
        listView.adapter = ContactsAdapter(this, getAllContacts())
        super.onResume()
    }

}
