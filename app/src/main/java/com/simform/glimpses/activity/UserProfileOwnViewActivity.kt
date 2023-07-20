package com.simform.glimpses.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.simform.glimpses.R
import com.simform.glimpses.adapter.ViewPagerAdapter
import com.simform.glimpses.databinding.ActivityUserProfileOwnViewsBinding

class UserProfileOwnViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileOwnViewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileOwnViewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tbLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.peeks)
                1 -> tab.text = getString(R.string.posts)
                2 -> tab.text = getString(R.string.lists)
            }
        }.attach()
    }

}