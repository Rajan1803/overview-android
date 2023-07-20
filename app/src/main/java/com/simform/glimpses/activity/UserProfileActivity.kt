package com.simform.glimpses.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.simform.glimpses.activities.ContactUsActivity
import com.simform.glimpses.adapter.UserProfileOptionAdapter
import com.simform.glimpses.databinding.ActivityUserProfileBinding
import com.simform.glimpses.model.UserProfileOptions

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding
    private lateinit var optionList: ArrayList<UserProfileOptions>
    private lateinit var optionListAdapter: UserProfileOptionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        optionList = UserProfileOptions.optionList

        binding.apply {
            rvUserProfile.layoutManager = LinearLayoutManager(this@UserProfileActivity)
            optionListAdapter = UserProfileOptionAdapter(optionList)
            rvUserProfile.adapter = optionListAdapter

            btnMyProfile.setOnClickListener {
                startActivity(
                    Intent(
                        this@UserProfileActivity,
                        UserProfileOwnViewActivity::class.java
                    )
                )
            }

            optionListAdapter.onClick = {
                when (it.itemName) {
                    "Contact Us" -> startActivity(
                        Intent(
                            this@UserProfileActivity,
                            ContactUsActivity::class.java
                        )
                    )

                    "FAQ" -> startActivity(
                        Intent(
                            this@UserProfileActivity,
                            FAQListActivity::class.java
                        )
                    )

                    else -> Snackbar.make(binding.root, it.itemName, Snackbar.LENGTH_LONG).show()
                }

            }
        }
    }

}