package com.example.uiandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.uiandroid.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("lifecycle mathods 2","onCreate")

        binding.btnFirstFragment.setOnClickListener {
            loadFragment(FirstFragment())
        }

        binding.btnSecondFragment.setOnClickListener {
            loadFragment(SecondFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
        Log.d("fragments",fragmentManager.fragments.toString())
    }


    override fun onResume() {
        super.onResume()
        Log.d("lifecycle mathods 2","onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle methods 2", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle mathods 2","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle mathods 2","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifecycle mathods 2","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle mathods 2","onDestroy")
    }


}