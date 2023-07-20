package com.simform.glimpses.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

object Utility {

    fun AppCompatActivity.toActivity(destination: Class<AppCompatActivity>): Intent {
        return Intent(this, destination)
    }

    fun isValidPassword(password: String?): Boolean {
        if (password == null) {
            return false
        }
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        val passwordMatcher = Regex(passwordPattern)
        return passwordMatcher.find(password) != null
    }

    fun isUsernameValid(email: String?): Boolean {
        return email?.isNotEmpty() ?: false
    }

}