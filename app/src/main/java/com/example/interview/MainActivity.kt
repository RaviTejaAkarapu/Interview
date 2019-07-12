package com.example.interview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import com.google.gson.Gson
import com.google.gson.JsonObject


class MainActivity : AppCompatActivity() {
    companion object {
        val STRING = "{\"Weakness Above 50 Yrs\": \"Weakness\", \"Gynaecology\": \"Gynaec Related Issues\", \"Joint Pain\": \"Joint Pain\", \"Insect Bite\": \"Insect Bite\", \"Vertigo in Young Female\": \"Vertigo\", \"Stool Related Issue\": \"Stool Related Issue\", \"Headache\": \"Headache\", \"Fever\": \"Fever\", \"Breathlessness\": \"Breathlessness\", \"Miscellaneous\": \"Miscellaneous\", \"Common Cold\": \"Common Cold\", \"Stress\": \"Stress\", \"Abdominal Pain\": \"Stomach Ache\", \"Throat Discomfort\": \"Throat Discomfort\", \"Vertigo in Old Age\": \"Vertigo\", \"Sleep Disturbance\": \"Sleep Disturbance\", \"Weakness Below 50 Yrs\": \"Weakness\", \"Vertigo in Young Male\": \"Vertigo\", \"Acidity\": \"Acidity\", \"LooseMotion\": \"Loose Motions\", \"Ear Discomfort\": \"Ear Discomfort\", \"Nose Bleeding\": \"Nose Bleeding\", \"Skin\": \"Skin Infections\"}"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?


        val gson = Gson()
        var expectedHashMap = HashMap<String, String>()
        expectedHashMap  = gson.fromJson(STRING, expectedHashMap.javaClass)
        val keys :ArrayList<String> = ArrayList()
        val values :ArrayList<String> = ArrayList()
        expectedHashMap.keys.forEach {
            Log.d("check", "key:$it , value ${expectedHashMap[it]}")
            keys.add(it)
            values.add(expectedHashMap[it]!!)
        }
        recyclerView.adapter = MainActivityAdapter(keys, values)

    }

}
