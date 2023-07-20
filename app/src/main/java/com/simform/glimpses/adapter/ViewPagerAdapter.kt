package com.simform.glimpses.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.simform.glimpses.fragment.PeeksFragment
import com.simform.glimpses.fragment.PostsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifeCycle) {

    enum class UserView {
        PEEKS,
        POSTS,
        LISTS
    }

    override fun getItemCount(): Int {
        return UserView.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (UserView.values()[position]) {
            UserView.PEEKS -> PeeksFragment()
            UserView.POSTS -> PostsFragment()
            UserView.LISTS -> PeeksFragment()
        }
    }

}