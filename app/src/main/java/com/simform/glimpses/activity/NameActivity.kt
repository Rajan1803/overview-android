package com.simform.glimpses.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.simform.glimpses.databinding.ActivityNameBinding
import com.simform.glimpses.helper.Validator
import com.simform.glimpses.loginActivities.BirthdayActivity

class NameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.apply {
            etFullName.addTextChangedListener {
                val isNameValid = Validator.validateName(binding.etFullName.text.toString())
                btnNameNext.isEnabled = isNameValid
                btnNameNext.alpha = if (isNameValid) 1.0f else 0.5f
            }

            btnNameNext.setOnClickListener {
                startActivity(Intent(this@NameActivity, BirthdayActivity::class.java))
            }
        }
    }

}