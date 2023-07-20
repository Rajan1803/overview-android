package com.simform.glimpses.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.simform.glimpses.adapter.GlimpsesItemDecoration
import com.simform.glimpses.adapter.UserPostAdapter
import com.simform.glimpses.databinding.FragmentPostsBinding
import com.simform.glimpses.model.UserPost

class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding
    private lateinit var postList: ArrayList<UserPost>
    private lateinit var userPostAdapter: UserPostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostsBinding.inflate(layoutInflater)

        initViews()
        return binding.root
    }

    private fun initViews() {
        postList = UserPost.postList
        userPostAdapter = UserPostAdapter(postList)

        binding.apply {
            rvProfilePosts.layoutManager = LinearLayoutManager(context)
            rvProfilePosts.adapter = userPostAdapter
            rvProfilePosts.addItemDecoration(GlimpsesItemDecoration())
        }
    }

}