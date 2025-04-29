package com.example.violation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.shashank.sony.fancytoastlib.FancyToast

class UserLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        val etUsername = findViewById<EditText>(R.id.etUserUsername)
        val etPassword = findViewById<EditText>(R.id.etUserPassword)
        val btnLogin = findViewById<Button>(R.id.btnUserLogin)

        // In real app, use proper authentication
        val userCredentials = mapOf(
            "user1" to "user123",
            "user2" to "user456"
        )

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                FancyToast.makeText(this, "Please enter both username and password", FancyToast.LENGTH_SHORT, FancyToast.INFO, true).show()
                return@setOnClickListener
            }

            if (userCredentials[username] == password) {

                val sessionManager = SessionManager(this)
                sessionManager.saveUserId(username)

                FancyToast.makeText(this, "Login successful", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show()

                val intent = Intent(this, UserDashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                FancyToast.makeText(this, "Invalid credentials", FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show()

            }
        }
    }
}
