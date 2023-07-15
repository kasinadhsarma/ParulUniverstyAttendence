package com.example.paruluniverstyattendence

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PietActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_piet)

        val btnCSE = findViewById<Button>(R.id.btn_CSE)
        btnCSE.setOnClickListener {
            val intent = Intent(this, CSEActivity::class.java)
            startActivity(intent)
        }
    }
}
