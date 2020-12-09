package com.example.customspinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class CustomAdapter : BaseAdapter() {

    override fun getCount(): Int {
        return country.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    lateinit var country: MutableList<Data>
    lateinit var inflater: LayoutInflater
    lateinit var context: Context


    fun customeSpinnerAdapter(context: Context, name: MutableList<Data>) {
        this.country = name
        this.context = context
        inflater = LayoutInflater.from(context)
    }

    override fun getView(i: Int, p1: View?, p2: ViewGroup?): View {
        val view = inflater.inflate(R.layout.custom_spinner_items, null)
        view.findViewById<TextView>(R.id.textView).setText(country.get(i).country)
        return view
    }
}