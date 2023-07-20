package com.simform.glimpses.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simform.glimpses.adapter.FAQAdapter
import com.simform.glimpses.databinding.ActivityFaqlistBinding
import com.simform.glimpses.model.FAQ

class FAQListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaqlistBinding
    private lateinit var adapter: FAQAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val faqList = FAQ.faqList
        adapter = FAQAdapter(faqList)

        binding.apply {
            lvFAQ.setAdapter(adapter)
        }
    }

}