package com.example.paruluniverstyattendence
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executor = ContextCompat.getMainExecutor(this)

        biometricPrompt = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                // Authentication succeeded!
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }

        })

        val biometricPromptForSignup = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                // Authentication succeeded for sign up!
                val intent = Intent(this@MainActivity, SignupActivity::class.java)
                startActivity(intent)
            }

        })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric login for my app")
            .setSubtitle("Log in using your biometric credential")
            .setNegativeButtonText("Use account password")
            .build()

        val loginButton = findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }

        val signUpButton = findViewById<Button>(R.id.btn_sign_up)
        signUpButton.setOnClickListener {
            biometricPromptForSignup.authenticate(promptInfo)
        }
    }
}
