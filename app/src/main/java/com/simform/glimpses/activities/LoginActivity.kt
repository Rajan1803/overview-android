package com.simform.glimpses.activities

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.simform.glimpses.R
import com.simform.glimpses.activity.ForgotPasswordActivity
import com.simform.glimpses.activity.SignupEmailActivity
import com.simform.glimpses.databinding.ActivityLoginBinding
import com.simform.glimpses.model.Utility

class LoginActivity : AppCompatActivity() {

    /**
     * variables
     */
    private lateinit var binding: ActivityLoginBinding

    /**
     * life cycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()

    }

    /**
     * set Up Views
     */
    private fun setUpViews() {
        val strCreateAccount = getString(R.string.new_to_sneakpeek_create_account)
        val strToBusinessAccount = getString(R.string.switch_to_business_account)
        var spanText = createSpannableString(
            strCreateAccount,
            strCreateAccount.indexOf(getString(R.string.create_account)),
            strCreateAccount.indexOf(getString(R.string.create_account)) + getString(R.string.create_account).length
        )

        binding.apply {
            txtvCreateAccount.text = spanText
            txtvCreateAccount.movementMethod = LinkMovementMethod.getInstance()

            spanText = createSpannableString(strToBusinessAccount, 0, strToBusinessAccount.length)
            txtvToBussnessAccount.text = spanText

            btnSignUp.isEnabled = false
            eTxtUsername.addTextChangedListener {
                setButtonState(validateFields())
            }

            eTxtPassword.addTextChangedListener {
                setButtonState(validateFields())
            }

            btnSignUp.setOnClickListener {
                val intent = Intent(this@LoginActivity, SelectInterestActivity::class.java)
                startActivity(intent)
            }

            txtVForgetPassword.setOnClickListener {
                startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
            }
        }
    }

    /**
     * set button state based on field verification
     */
    private fun setButtonState(isValid: Boolean) {
        if (isValid) {
            binding.btnSignUp.apply {
                alpha = 1f
                isEnabled = true
            }
        } else {
            binding.btnSignUp.apply {
                alpha = 0.5f
                isEnabled = false
            }
        }
    }

    /**
     * return true if both fields are valid
     */
    private fun validateFields(): Boolean {
        return Utility.isUsernameValid(binding.eTxtUsername.text.toString()) && Utility.isValidPassword(
            binding.eTxtPassword.text.toString()
        )
    }

    /**
     * function to create spannableString
     */
    private fun createSpannableString(string: String, start: Int, end: Int): SpannableString {
        val spanText = SpannableString(string)
        val clickAction = object : ClickableSpan() {
            override fun onClick(view: View) {
                startActivity(Intent(this@LoginActivity, SignupEmailActivity::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = getColor(R.color.mint)
            }
        }
        spanText.setSpan(clickAction, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        return spanText
    }

}