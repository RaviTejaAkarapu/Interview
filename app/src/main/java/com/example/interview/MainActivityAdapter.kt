package com.example.interview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class MainActivityAdapter(
    val keys: ArrayList<String>,
    val values: ArrayList<String>
) : RecyclerView.Adapter<MainActivityViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainActivityViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val recyclerView = layoutInflater.inflate(R.layout.recyclerview_row, p0, false)
        return MainActivityViewHolder(recyclerView)
    }

    override fun getItemCount(): Int = keys.size

    override fun onBindViewHolder(p0: MainActivityViewHolder, p1: Int) {

        p0.button.text = keys[p1]
        p0.button.setOnClickListener {
            Toast.makeText(p0.button.context, values[p1], Toast.LENGTH_SHORT).show()
        }
    }
}

class MainActivityViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    lateinit var button: Button

    init {
        button = v.button
    }
}

