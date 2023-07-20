package com.simform.glimpses.loginActivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.R
import com.simform.glimpses.customViews.OTPView
import java.util.concurrent.TimeUnit

class VerificationActivity : AppCompatActivity() {

    private lateinit var otpView: OTPView
    private lateinit var tvTimer: TextView
    private lateinit var tvResend: TextView
    private lateinit var tvChangeVerification: TextView
    private lateinit var tvEmailText: TextView

    private val email = "pdSimform@gmail.com"

    private var countDownTimer = object : CountDownTimer(30_000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val minutes = String.format(
                "%02d:%02d",
                (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
                (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                ))
            )
            tvTimer.text = minutes
        }

        override fun onFinish() {
            tvResend.setTextAppearance(R.style.TextView_Normal_Mint)
            tvResend.isEnabled = true
            Toast.makeText(
                this@VerificationActivity,
                getString(R.string.you_can_tap_to_resend_otp),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, VerificationActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verficaion)
        initViews()
        setupViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }

    private fun initViews() {
        otpView = findViewById(R.id.otpViewVerification)
        tvTimer = findViewById(R.id.tvTimer)
        tvResend = findViewById(R.id.tvTapResend)
        tvChangeVerification = findViewById(R.id.tvChangeVerification)
        tvEmailText = findViewById(R.id.tvEmailText)
    }

    private fun setupViews() {
        tvEmailText.text = String.format(
            resources.getString(R.string.emailMessage),
            resources.getString(R.string.we_have_sent_a_code_to_your_email),
            email
        )
        countDownTimer.start()
        otpView.setOTPListener {
            countDownTimer.cancel()
            startActivity(PasswordActivity.getIntent(this@VerificationActivity))
            finish()
        }
        tvResend.setOnClickListener {
            Toast.makeText(applicationContext, getString(R.string.resending), Toast.LENGTH_SHORT)
                .show()
        }
        tvChangeVerification.setOnClickListener {
            Toast.makeText(
                applicationContext,
                getString(R.string.verification_method_changed),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}