package com.example.chucknorisjokes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorisjokes.R
import com.example.chucknorisjokes.fragments.RandomFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // make the launcher screen as first fragment

        supportFragmentManager.beginTransaction().replace(R.id.nav_container, RandomFragment()).commit()
    }
}