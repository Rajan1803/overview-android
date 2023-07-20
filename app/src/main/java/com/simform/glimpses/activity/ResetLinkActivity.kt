package com.simform.glimpses.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.activities.LoginActivity
import com.simform.glimpses.databinding.ActivityResetLinkBinding

class ResetLinkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetLinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnGoSignIn.setOnClickListener {
                startActivity(Intent(this@ResetLinkActivity, LoginActivity::class.java))
            }
        }
    }
}