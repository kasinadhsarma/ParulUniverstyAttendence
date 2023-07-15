package com.example.paruluniverstyattendence

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai)

        val btnDiv1 = findViewById<Button>(R.id.btn_div1)
        btnDiv1.setOnClickListener {
            // Create an Intent to start FormActivity
            val intent = Intent(this, FormActivity::class.java)
            // Start FormActivity
            startActivity(intent)
        }
        // ...add more button listeners here, up to div10
    }
}
