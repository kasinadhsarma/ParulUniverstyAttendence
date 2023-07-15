package com.example.paruluniverstyattendence

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AIActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai)

        // Initialize DatabaseHelper
        databaseHelper = DatabaseHelper(this)
        db = databaseHelper.writableDatabase

        val btnDiv1 = findViewById<Button>(R.id.btn_div1)
        btnDiv1.setOnClickListener {
            // Add your action for Division 1 button here
            val enrollmentNumber = "12345" // Replace with the actual enrollment number
            val name = "John Doe" // Replace with the actual name

            // Insert data into the database
            val values = ContentValues().apply {
                put("enrollmentnumber", enrollmentNumber)
                put("name", name)
            }
            db.insert("users", null, values)
        }
        // ...add more button listeners here, up to div10
    }
}
