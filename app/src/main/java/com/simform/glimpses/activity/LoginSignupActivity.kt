package com.simform.glimpses.activity

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.R
import com.simform.glimpses.activities.LoginActivity
import com.simform.glimpses.databinding.ActivityLoginSignupBinding


class LoginSignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        setTermsPrivacy()
        setSignIn()

        binding.apply {
            txtCreateAccount.setOnClickListener {
                startActivity(Intent(this@LoginSignupActivity, SignupEmailActivity::class.java))
            }

            txtSignIn.setOnClickListener {
                startActivity(Intent(this@LoginSignupActivity, LoginActivity::class.java))
            }
        }

    }

    /**
     * Tap on SignIn
     */
    private fun setSignIn() {
        val signIn = getString(R.string.already_have_an_account)
        val spannableString = SpannableString(signIn)

        val clickableSignIn: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                //
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = getColor(R.color.mint)
                ds.isUnderlineText = false
                ds.bgColor = getColor(R.color.bgBlack)
            }
        }
        val signInString = resources.getString(R.string.signIn)
        spannableString.setSpan(
            clickableSignIn,
            signIn.indexOf(signInString),
            signIn.indexOf(signInString) + (signInString).length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.txtSignIn.text = spannableString
        binding.txtSignIn.movementMethod = LinkMovementMethod.getInstance()
    }

    /**
     * Tap on Terms & Conditions and Privacy Policy
     */
    private fun setTermsPrivacy() {
        val termsPrivacy = resources.getString(R.string.terms_privacy)
        val spannableString = SpannableString(termsPrivacy)

        val termsClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                startActivity(Intent(this@LoginSignupActivity, TermsConditionsActivity::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = getColor(R.color.lightGrey)
                ds.isUnderlineText = false
                ds.bgColor = getColor(R.color.bgBlack)
            }
        }

        val privacyClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                startActivity(Intent(this@LoginSignupActivity, TermsConditionsActivity::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = getColor(R.color.lightGrey)
                ds.isUnderlineText = false
                ds.bgColor = getColor(R.color.bgBlack)
            }
        }

        val tcString = resources.getString(R.string.termsAndConditions)
        val privacyString = resources.getString(R.string.privacyPolicy)
        spannableString.setSpan(
            termsClickableSpan,
            termsPrivacy.indexOf(tcString),
            termsPrivacy.indexOf(tcString) + (tcString).length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            privacyClickableSpan,
            termsPrivacy.indexOf(privacyString),
            termsPrivacy.indexOf(privacyString) + (privacyString).length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.txtTermsPrivacy.text = spannableString
        binding.txtTermsPrivacy.movementMethod = LinkMovementMethod.getInstance()
    }

}