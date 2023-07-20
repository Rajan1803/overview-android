package com.simform.glimpses.activities

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.simform.glimpses.databinding.ActivityPhotoPickerBinding

class PhotoPickerActivity : AppCompatActivity() {

    /**
     * variables
     */
    private lateinit var binding: ActivityPhotoPickerBinding

    /**
     * lifecycle methods
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        binding = ActivityPhotoPickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.isEnabled = false
        binding.btnPlus.setOnClickListener {

            val galleryIntent = Intent(Intent.ACTION_PICK)
            galleryIntent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(galleryIntent, 222)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, SelectInterestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 222) {
                binding.apply {
                    imgView.setImageURI(data?.data)
                    btnNext.alpha = 1f
                    btnNext.isEnabled = true
                    btnPlus.isGone = true
                }
            }
        }
    }
}