package com.example.garoz.lab51

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Adaptador para mostrar elementos del menú de manera ordenada
 */

class ContactsAdapter(private val context: Context,
                      private val dataSource: ArrayList<String>):BaseAdapter() {

    /**
     * Inflador para layout con objetos del menú
     */
    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    /**
     * Por cada elemento se muestra su nombre en la layout definida
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item

        val rowView = inflater.inflate(R.layout.one_contact, parent, false)

        val titleTextView = rowView.findViewById(R.id.itemName) as TextView

        val recipe = getItem(position) as String

        titleTextView.text = recipe


        return rowView
    }
}