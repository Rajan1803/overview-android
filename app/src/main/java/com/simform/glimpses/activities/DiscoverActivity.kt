package com.simform.glimpses.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.simform.glimpses.databinding.ActivityDiscoverBinding

class DiscoverActivity : AppCompatActivity() {

    /**
     * variables
     */
    private lateinit var binding: ActivityDiscoverBinding

    /**
     * life cycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityDiscoverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnContinue.setOnClickListener {
            val intent = Intent(this, OnboardActivity::class.java)
            startActivity(intent)
        }
        binding.btnContinueBusiness.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
    }

}