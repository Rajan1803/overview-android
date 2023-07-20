package com.simform.glimpses.activities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    /**
     * number of items in viewpager
     */
    override fun getItemCount(): Int {
        return 3
    }

    /**
     * fragment to display on viewpager
     */
    override fun createFragment(position: Int): Fragment {
        return OnboardFragment()
    }

}