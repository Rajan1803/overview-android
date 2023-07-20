package com.simform.glimpses.loginActivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import com.simform.glimpses.R
import com.simform.glimpses.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding
    private val oldPassword = "123@Simform"

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, ResetPasswordActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.apply {
            etPassword.doOnTextChanged { text, _, _, _ ->
                checkPassword(text.toString())
            }

            etRePassword.doOnTextChanged { _, _, _, _ ->
                btnNext.isEnabled = checkGotoNext()
            }

            btnNext.setOnClickListener {
                startActivity(BirthdayActivity.getIntent(this@ResetPasswordActivity))
                finish()
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
                etRePassword.error = getString(R.string.must_be_same_as_password)
                btnNext.isEnabled = false
                false
            } else {
                etRePassword.error = null
                btnNext.isEnabled = true
                true
            }
        }
    }

    private fun compareOldPassword(password: String): Boolean {
        binding.apply {
            return if (password.compareTo(oldPassword) == 0) {
                etPassword.error = getString(R.string.old_password_and_new_password_cannot_be_same)
                btnNext.isEnabled = false
                false
            } else {
                etPassword.error = null
                btnNext.isEnabled = true
                true
            }
        }
    }

    private fun checkGotoNext(): Boolean {
        binding.apply {
            return (tvPasswordHintOne.currentTextColor == ContextCompat.getColor(
                applicationContext, R.color.mint
            ) && tvPasswordHintOne.currentTextColor == tvPasswordHintTwo.currentTextColor && tvPasswordHintOne.currentTextColor == tvPasswordHintThree.currentTextColor && comparePasswords(
                etPassword.text.toString(), etRePassword.text.toString()
            )) && compareOldPassword(etPassword.text.toString())
        }
    }

}