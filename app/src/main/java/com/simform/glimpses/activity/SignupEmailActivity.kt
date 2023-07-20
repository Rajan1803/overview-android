package com.simform.glimpses.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.simform.glimpses.databinding.ActivitySignupEmailBinding
import com.simform.glimpses.helper.Validator
import com.simform.glimpses.loginActivities.VerificationActivity

class SignupEmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.apply {
            etEmail.addTextChangedListener {
                val isEmailValid = Validator.validateEmail(binding.etEmail.text.toString())
                btnNext.isEnabled = isEmailValid
                btnNext.alpha = if (isEmailValid) 1.0f else 0.5f
            }

            btnNext.setOnClickListener {
                startActivity(Intent(this@SignupEmailActivity, VerificationActivity::class.java))
            }
        }
    }

}