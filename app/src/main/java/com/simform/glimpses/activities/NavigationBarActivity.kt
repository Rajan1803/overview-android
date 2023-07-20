package com.simform.glimpses.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.simform.glimpses.R
import com.simform.glimpses.activity.UserProfileActivity
import com.simform.glimpses.databinding.ActivityNavigationBarBinding

class NavigationBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBarBinding

    /**
     * life cycle method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(PeeksFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.locationNav -> {
                    openFragment(PeeksFragment())
                }

                R.id.playNav -> {
                    openFragment(OnboardFragment())
                }

                R.id.listNav -> {
                    openFragment(PeeksFragment())
                }

                R.id.searchNav -> {
                    openFragment(OnboardFragment())
                }

                R.id.profileNav -> {
                    startActivity(
                        Intent(
                            this@NavigationBarActivity,
                            UserProfileActivity::class.java
                        )
                    )
                }
            }
            true
        }
    }

    /**
     * method to open fragment
     */
    private fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainer.id, fragment)
        fragmentTransaction.commit()
    }
}
