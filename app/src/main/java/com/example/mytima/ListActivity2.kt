package com.example.mytima

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ListActivity2 : AppCompatActivity() {
    lateinit var buttonBeck: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list2)



        buttonBeck = findViewById(R.id.buttonBeck)
        buttonBeck.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        




    }
}