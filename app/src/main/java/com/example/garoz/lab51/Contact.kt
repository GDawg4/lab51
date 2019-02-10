package com.example.garoz.lab51

import android.provider.ContactsContract

data class Contact(val name: String,
                   val number: Int,
                   val email: String,
                   val photo:ContactsContract.Contacts.Photo)