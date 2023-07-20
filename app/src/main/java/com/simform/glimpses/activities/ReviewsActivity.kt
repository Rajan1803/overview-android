package com.simform.glimpses.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.databinding.ActivityReviewsBinding

class ReviewsActivity : AppCompatActivity() {

    private lateinit var bottomSheetFragment: BottomSheetFragment
    private lateinit var binding: ActivityReviewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReviewNow.setOnClickListener {
            bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, "fragment")
        }
    }
}