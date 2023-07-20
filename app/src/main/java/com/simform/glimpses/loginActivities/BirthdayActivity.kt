package com.simform.glimpses.loginActivities

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.activities.PhotoPickerActivity
import com.simform.glimpses.databinding.ActivityBirthdayBinding
import com.simform.glimpses.helper.Constant
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class BirthdayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBirthdayBinding
    private val myCalendar = Calendar.getInstance()

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, BirthdayActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBirthdayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners() {
        val date = OnDateSetListener { _, year, month, day ->
            myCalendar[Calendar.YEAR] = year
            myCalendar[Calendar.MONTH] = month
            myCalendar[Calendar.DAY_OF_MONTH] = day
            updateDateSelected()
        }
        binding.apply {
            etBirthDate.setOnClickListener {
                DatePickerDialog(
                    this@BirthdayActivity,
                    date,
                    myCalendar[Calendar.YEAR],
                    myCalendar[Calendar.MONTH],
                    myCalendar[Calendar.DAY_OF_MONTH]
                ).show()
            }
            btnNext.setOnClickListener {
                startActivity(Intent(this@BirthdayActivity, PhotoPickerActivity::class.java))
                finish()
            }
        }
    }

    private fun updateDateSelected() {
        val dateFormat = SimpleDateFormat(Constant.birthdayDateFormat, Locale.getDefault())
        binding.apply {
            etBirthDate.setText(dateFormat.format(myCalendar.time))
            btnNext.isEnabled = true
        }
    }

}