package com.simform.glimpses.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.simform.glimpses.ButtonClick
import com.simform.glimpses.RecycleInterestAdapter
import com.simform.glimpses.databinding.ActivitySelectIntrestBinding
import com.simform.glimpses.loginActivities.BusinessHoursActivity
import com.simform.glimpses.model.InterestModel

class SelectInterestActivity : AppCompatActivity(), ButtonClick {

    /**
     * variables
     */
    private lateinit var binding: ActivitySelectIntrestBinding

    /**
     * life cycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        binding = ActivitySelectIntrestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfInterests = InterestModel.listOfInterests

        val recycleInterestAdapter = RecycleInterestAdapter(listOfInterests)
        recycleInterestAdapter.delegate = this

        binding.recycleVIntrest.apply {
            layoutManager = GridLayoutManager(this@SelectInterestActivity, 3)
            adapter = recycleInterestAdapter

        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this@SelectInterestActivity, BusinessHoursActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onButtonClick(selectedNumber: Int) {
        if (selectedNumber >= 3) {
            binding.btnNext.apply {
                alpha = 1f
                isEnabled = true
            }
        } else {
            binding.btnNext.apply {
                alpha = 0.5f
                isEnabled = false
            }
        }
    }
}