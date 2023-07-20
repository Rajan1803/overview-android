package com.simform.glimpses.loginActivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import com.simform.glimpses.R
import com.simform.glimpses.activity.NameActivity
import com.simform.glimpses.databinding.ActivityPasswordBinding

class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, PasswordActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.apply {
            etPassword.doOnTextChanged { text, _, _, _ ->
                checkPassword(text.toString())
            }
            etRePassword.doOnTextChanged { _, _, _, _ ->
                binding.btnNext.isEnabled = checkGotoNext()
            }
            btnNext.setOnClickListener {
                startActivity(Intent(this@PasswordActivity, NameActivity::class.java))
            }
        }
    }

    private fun checkPassword(text: String) {
        binding.apply {
            val greyColor = ContextCompat.getColor(
                applicationContext, R.color.textGrey
            )
            val mintColor = ContextCompat.getColor(
                applicationContext, R.color.mint
            )
            if (text.isEmpty()) {
                tvPasswordHintOne.setTextColor(greyColor)
                tvPasswordHintTwo.setTextColor(greyColor)
                tvPasswordHintThree.setTextColor(greyColor)
                btnNext.isEnabled = false
                return
            }
            if (text.length < 8) {
                tvPasswordHintOne.setTextColor(greyColor)
                btnNext.isEnabled = false
            } else {
                tvPasswordHintOne.setTextColor(mintColor)
            }
            if (!text.contains("[!@$%&~]".toRegex())) {
                tvPasswordHintTwo.setTextColor(greyColor)
                btnNext.isEnabled = false
            } else {
                tvPasswordHintTwo.setTextColor(mintColor)
            }
            if (!(text.contains("\\d".toRegex()) && text.contains("[a-zA-Z]".toRegex()))) {
                tvPasswordHintThree.setTextColor(greyColor)
                btnNext.isEnabled = false
            } else {
                tvPasswordHintThree.setTextColor(mintColor)
            }
            btnNext.isEnabled = checkGotoNext()
        }
    }

    private fun comparePasswords(passOne: String, passTwo: String): Boolean {
        binding.apply {
            return if (passOne.compareTo(passTwo) != 0) {
                btnNext.isEnabled = false
                false
            } else {
                btnNext.isEnabled = true
                true
            }
        }
    }

    private fun checkGotoNext(): Boolean {
        return (binding.tvPasswordHintOne.currentTextColor == ContextCompat.getColor(
            applicationContext, R.color.mint
        ) && binding.tvPasswordHintOne.currentTextColor == binding.tvPasswordHintTwo.currentTextColor && binding.tvPasswordHintOne.currentTextColor == binding.tvPasswordHintThree.currentTextColor && comparePasswords(
            binding.etPassword.text.toString(), binding.etRePassword.text.toString()
        ))
    }

}