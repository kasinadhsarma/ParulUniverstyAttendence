// UsersListActivity.kt
package com.example.paruluniverstyattendence

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class UsersListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)

        val dbHandler = DatabaseHelper(this)
        val users = dbHandler.getAllUsers()
        val usersListView = findViewById<ListView>(R.id.lv_users)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users.map { "${it.enrollmentNumber} - ${it.name} - ${it.biometricAuthentication}" })
        usersListView.adapter = adapter
    }
}
