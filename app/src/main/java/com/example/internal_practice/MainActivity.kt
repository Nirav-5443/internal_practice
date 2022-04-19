package com.example.internal_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refreshRecycler()
        btnsubmit.setOnClickListener {
            var name = edtname.text.toString()
            var age = edtage.text.toString().toInt()
            var p = Person(name, age)
            var db = DBHelper(this)
            var flag = db.insert(p)
            if (flag > 0){
                Toast.makeText(this, "Record Inserted!!", Toast.LENGTH_LONG).show()
                edtname.setText("")
                edtage.setText("")
                refreshRecycler()
            }
        }
    }

    fun refreshRecycler(){
        var db = DBHelper(this)
        var arr : ArrayList<Person> = db.retriveAll()
        var adapter = PersonAdapter(this, arr)
        recyclerview.adapter = adapter
    }


}