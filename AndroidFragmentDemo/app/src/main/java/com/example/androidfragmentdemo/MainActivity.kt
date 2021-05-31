package com.example.androidfragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Change = findViewById<Button>(R.id.btn_change)

        Change.setOnClickListener {
            if (isFragmentOneLoaded) {
                ShowFragmentTwo()
            } else {
                ShowFragmentOne()
            }
        }
    }

    fun ShowFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragmentOne = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragmentOne)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true

    }

    fun ShowFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragmentTwo = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragmentTwo)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false

    }


}