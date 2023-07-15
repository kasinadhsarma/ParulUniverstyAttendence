package com.example.paruluniverstyattendence

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CSEActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cse)

        val btnAI = findViewById<Button>(R.id.btn_AI)
        btnAI.setOnClickListener {
            val intent = Intent(this, AIActivity::class.java)
            startActivity(intent)
        }

        // Continue this process for all other specializations in the CSE department.
    }
}
