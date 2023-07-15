package com.example.paruluniverstyattendence

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "UserDB" // name of the database
        private const val DATABASE_VERSION = 1 // version of the database
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE users(
                enrollmentnumber TEXT PRIMARY KEY, 
                name TEXT, 
                email TEXT,
                password TEXT,
                biometricauthentication INTEGER DEFAULT 0
            )
            """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun insertUser(enrollmentNumber: String, name: String, email: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("enrollmentnumber", enrollmentNumber)
            put("name", name)
            put("email", email)
            put("password", password)
        }
        return db.insert("users", null, values)
    }
}
