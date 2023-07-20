package com.simform.glimpses.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.simform.glimpses.databinding.ActivityForgotPasswordBinding
import com.simform.glimpses.helper.Validator

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.apply {
            etForgotEmail.addTextChangedListener {
                val isEmailValid = Validator.validateEmail(binding.etForgotEmail.text.toString())
                btnForgotSubmit.isEnabled = isEmailValid
                btnForgotSubmit.alpha = if (isEmailValid) 1.0f else 0.5f
            }

            btnForgotSubmit.setOnClickListener {
                startActivity(Intent(this@ForgotPasswordActivity, ResetLinkActivity::class.java))
                finish()
            }
        }
    }

}