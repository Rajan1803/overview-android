package com.example.uiandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.uiandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(applicationContext, "hello", Toast.LENGTH_SHORT).show()
       // val btnClickHere = findViewById<Button >(R.id.btnClickHere)

        binding.btnClickHere.setOnClickListener {
            //Toast.makeText(applicationContext, "Toast", Toast.LENGTH_SHORT).show()
            makeToast(toastImage = R.drawable.toast_icon, toastTitle = "this is toast" )
            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            startActivity(intent)
        }

        Log.d("lifecycle mathods","onCreat")



    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.d("lifecycle mathods","onTrimMemory")
        Log.d("lifecycle mathods", level.toString())
    }
    override fun onStart() {
        super.onStart()
        Log.d("lifecycle mathods","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle mathods","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle mathods","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle mathods","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifecycle mathods","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle mathods","onDestroy")
    }

    fun makeToast(toastImage: Int, toastTitle: String) {
        val layoutInflater = getLayoutInflater()
        val layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.linearlayout))
        layout.findViewById<ImageView>(R.id.toast_imgView).setImageResource(toastImage)
        layout.findViewById<TextView>(R.id.toast_textView).setText(toastTitle)
        val toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER, 0 , 0 )
        toast.setDuration(Toast.LENGTH_LONG)
        toast.setView(layout)
        toast.show()
    }
}