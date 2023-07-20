package com.simform.glimpses.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.simform.glimpses.databinding.ActivityLocationBinding
import com.simform.glimpses.model.RecycleViewMargin
import com.simform.glimpses.viewHolders.RecycleLocationAdapter

class LocationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLocationBinding

    /**
     * life cycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleviewLocation.apply {
            layoutManager = LinearLayoutManager(this@LocationActivity)
            addItemDecoration(RecycleViewMargin(30, 30, 30, 30))
            adapter = RecycleLocationAdapter()
        }
    }
}