package com.example.liga

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun init(){
        val toggle = ActionBarDrawerToggle(this, drawerLayout, null, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
}