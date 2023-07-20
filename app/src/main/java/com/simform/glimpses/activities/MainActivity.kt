package com.simform.glimpses.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.R

class MainActivity : AppCompatActivity() {

    /**
     * life cycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}