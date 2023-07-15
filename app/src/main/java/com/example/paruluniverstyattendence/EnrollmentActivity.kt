package com.example.paruluniverstyattendence

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EnrollmentActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enrollment)

        databaseHelper = DatabaseHelper(this)
        val editTextEnrollment = findViewById<EditText>(R.id.editTextEnrollment)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val enrollment = editTextEnrollment.text.toString().trim()
            val name = editTextName.text.toString().trim()
            // assuming these values are filled in the EditText fields, replace with actual values
            val email = "example@gmail.com"
            val password = "password123"

            val result = databaseHelper.insertUser(enrollment, name, email, password)
            if (result == -1L) {
                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
