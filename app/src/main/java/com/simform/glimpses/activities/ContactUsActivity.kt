package com.simform.glimpses.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.simform.glimpses.R
import com.simform.glimpses.databinding.ActivityContactUsBinding
import com.simform.glimpses.loginActivities.BusinessHoursActivity

class ContactUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactUsBinding
    private var isImageSelected = false

    private val galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val intent: Intent? = result.data
            binding.imageView.setImageURI(intent?.data)
            isImageSelected = true
            setButtonState(checkValidations())
        }
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, ContactUsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpAdapter()
        setUpListeners()
    }

    private fun setUpAdapter() {
        val adapter = ArrayAdapter(
            applicationContext,
            R.layout.item_spinner_dialog,
            resources.getTextArray(R.array.array_issue_selected)
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSelectedIssue.adapter = adapter
    }

    private fun setUpListeners() {
        binding.apply {
            btnImageEdit.setOnClickListener {
                pickImageFromGallery()
            }
            btnImageDelete.setOnClickListener {
                imageView.setImageResource(R.drawable.icon_profile_placeholder)
                isImageSelected = false
                setButtonState(false)
            }
            btnSend.setOnClickListener {
                startActivity(BusinessHoursActivity.getIntent(this@ContactUsActivity))
                finish()
            }
            etDescription.doOnTextChanged { _, _, _, _ ->
                setButtonState(checkValidations())
            }
            spinnerSelectedIssue.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        setButtonState(checkValidations())
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            etIssueTitle.doOnTextChanged { _, _, _, _ ->
                setButtonState(checkValidations())
            }
        }
    }

    private fun checkValidations(): Boolean = binding.run {
        checkString(etIssueTitle.text.toString()) && checkString(etDescription.text.toString()) && isImageSelected
    }

    private fun checkString(text: String): Boolean = text.length > 3

    private fun setButtonState(state: Boolean) {
        binding.btnSend.isEnabled = state
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.apply {
            type = "image/*"
            putExtra(Intent.EXTRA_LOCAL_ONLY, true)
        }
        galleryActivityResultLauncher.launch(intent)
    }

}