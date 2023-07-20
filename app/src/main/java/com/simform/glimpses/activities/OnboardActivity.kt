package com.simform.glimpses.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.simform.glimpses.activity.LoginSignupActivity
import com.simform.glimpses.databinding.ActivityOnboardingBinding

class OnboardActivity : AppCompatActivity() {

    /**
     * variables
     */
    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var fragmentAdapter: OnboardPager

    @SuppressLint("MissingInflatedId")
    /**
     * life cycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentAdapter = OnboardPager(fragmentManager = supportFragmentManager, lifecycle)
        binding.viewPager.adapter = fragmentAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
        }.attach()
        binding.btnGetStarted.setOnClickListener {
            val intent = Intent(this, LoginSignupActivity::class.java)
            startActivity(intent)
        }

    }
}