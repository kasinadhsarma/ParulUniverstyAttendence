package com.example.paruluniverstyattendence

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class User(
    var enrollmentNumber: String,
    var name: String,
    var biometricAuthentication: Int
)

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
                biometricauthentication INTEGER DEFAULT 0
            )
            """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun getAllUsers(): List<User> {
        val usersList = ArrayList<User>()
        val selectQuery = "SELECT  * FROM users"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val enrollmentNumberIndex = cursor.getColumnIndex("enrollmentnumber")
                val nameIndex = cursor.getColumnIndex("name")
                val biometricAuthenticationIndex = cursor.getColumnIndex("biometricauthentication")

                if (enrollmentNumberIndex != -1 && nameIndex != -1 && biometricAuthenticationIndex != -1) {
                    val user = User(
                        cursor.getString(enrollmentNumberIndex),
                        cursor.getString(nameIndex),
                        cursor.getInt(biometricAuthenticationIndex)
                    )
                    usersList.add(user)
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        return usersList
    }
}
