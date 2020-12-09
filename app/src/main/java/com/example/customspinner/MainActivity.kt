package com.example.customspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var dataModel: MutableList<Data> = mutableListOf<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataModel.add(Data(10, "India"))
        dataModel.add(Data(15, "China"))
        dataModel.add(Data(58, "America"))
        dataModel.add(Data(47, "Delhi"))

        val spin = findViewById<View>(R.id.simpleSpinner) as Spinner
        spin.onItemSelectedListener = this
        val customAdapter = CustomAdapter()
        customAdapter.customeSpinnerAdapter(applicationContext, dataModel)
        spin.adapter = customAdapter
    }

    override fun onItemSelected(
        adapterView: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        Toast.makeText(
            getApplicationContext(),
            dataModel[position].id.toString() + " " + dataModel[position].country,
            Toast.LENGTH_LONG
        ).show();
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}