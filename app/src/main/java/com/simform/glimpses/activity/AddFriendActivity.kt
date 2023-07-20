package com.simform.glimpses.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.simform.glimpses.R
import com.simform.glimpses.activities.NavigationBarActivity
import com.simform.glimpses.adapter.AddFriendAdapter
import com.simform.glimpses.adapter.ClickAddFriendListener
import com.simform.glimpses.databinding.ActivityAddFriendBinding
import com.simform.glimpses.model.Friend

class AddFriendActivity : AppCompatActivity(), ClickAddFriendListener {

    private lateinit var binding: ActivityAddFriendBinding
    private lateinit var addFriendList: ArrayList<Friend>
    private lateinit var searchList: ArrayList<Friend>
    private lateinit var addFriendAdapter: AddFriendAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFriendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        searchList = ArrayList()
        addFriendAdapter = AddFriendAdapter(searchList, this)
        addFriendList = Friend.friendList
        searchList.addAll(addFriendList)

        binding.apply {
            tvFriendCount.text = getString(R.string.friend_count, "0")

            rvAddFriend.layoutManager = LinearLayoutManager(this@AddFriendActivity)
            rvAddFriend.adapter = addFriendAdapter

            etSearch.addTextChangedListener {
                searchDataList(it.toString())
            }

            btnAddFriendNext.alpha = 1.0F
            btnAddFriendNext.isEnabled = true
            btnAddFriendNext.setOnClickListener {
                startActivity(Intent(this@AddFriendActivity, NavigationBarActivity::class.java))
            }
        }

    }

    /**
     * Search in RecyclerView
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun searchDataList(query: String?) {
        if (query != null) {
            searchList.clear()
            addFriendList.forEach {
                if (it.name.lowercase().contains(query.lowercase())) {
                    searchList.add(it)
                }
            }
            binding.rvAddFriend.adapter?.notifyDataSetChanged()
        } else {
            searchList.clear()
            searchList.addAll(addFriendList)
            binding.rvAddFriend.adapter?.notifyDataSetChanged()
        }
    }

    override fun onClickAddFriend() {
        val cnt = addFriendList.filter {
            it.isAdded
        }.size.toString()
        binding.tvFriendCount.text = getString(R.string.friend_count, cnt)
    }

}