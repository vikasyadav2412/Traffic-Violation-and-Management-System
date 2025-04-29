package com.example.violation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Enable edge-to-edge layout
        setContentView(R.layout.activity_user_profile)

        // Ensure that the main content area has correct padding to account for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Bottom Navigation View
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set default selected item
        bottomNav.selectedItemId = R.id.nav_profile

        // Set item selected listener for bottom navigation
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    // Navigate to user dashboard activity
                    startActivity(Intent(this, UserDashboardActivity::class.java))
                    overridePendingTransition(0, 0)  // Prevent animation transition
                    true
                }
                R.id.nav_profile -> true  // Do nothing if the current item is selected
                else -> false
            }
        }
    }
}
