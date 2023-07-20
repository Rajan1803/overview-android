package com.simform.glimpses.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.simform.glimpses.adapter.GlimpsesItemDecoration
import com.simform.glimpses.adapter.UserPeekAdapter
import com.simform.glimpses.databinding.FragmentPeeksBinding
import com.simform.glimpses.model.UserPeek

class PeeksFragment : Fragment() {

    private lateinit var binding: FragmentPeeksBinding
    private lateinit var peekList: ArrayList<UserPeek>
    private lateinit var userPeeksAdapter: UserPeekAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPeeksBinding.inflate(layoutInflater)

        initViews()
        return binding.root
    }

    private fun initViews() {
        peekList = UserPeek.userPeekList
        userPeeksAdapter = UserPeekAdapter(peekList)

        binding.apply {
            rvProfilePeeks.layoutManager = GridLayoutManager(context, 3)
            rvProfilePeeks.adapter = userPeeksAdapter
            rvProfilePeeks.addItemDecoration(GlimpsesItemDecoration())
        }
    }

}