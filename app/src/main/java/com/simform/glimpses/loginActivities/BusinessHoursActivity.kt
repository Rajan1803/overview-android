package com.simform.glimpses.loginActivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.simform.glimpses.R
import com.simform.glimpses.activity.AddFriendActivity
import com.simform.glimpses.adapter.WeekDayAdapter
import com.simform.glimpses.databinding.ActivityBusinessHoursBinding
import com.simform.glimpses.decorations.RecyclerViewItemDecoration
import com.simform.glimpses.model.WeekDay

class BusinessHoursActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBusinessHoursBinding
    private var days: ArrayList<WeekDay> = WeekDay.days
    private lateinit var weekDayAdapter: WeekDayAdapter

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, BusinessHoursActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessHoursBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.rvBusinessHours.apply {
            layoutManager = LinearLayoutManager(this@BusinessHoursActivity)
            binding.rvBusinessHours.addItemDecoration(
                RecyclerViewItemDecoration(
                    applicationContext,
                    R.drawable.divider_item_decoration_recycler_view
                )
            )
            weekDayAdapter = WeekDayAdapter()
            binding.rvBusinessHours.adapter = weekDayAdapter
            weekDayAdapter.submitList(days.toMutableList())
        }

        binding.btnNext.alpha = 1.0F
        binding.btnNext.isEnabled = true
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this@BusinessHoursActivity, AddFriendActivity::class.java))
        }
        // IF want to use DividerItem Decoration.
//        val dividerItemDecoration = DividerItemDecoration(
//            this,
//            DividerItemDecoration.VERTICAL
//        )
//        dividerItemDecoration.drawable?.setTint(getColor(R.color.offBlack))
    }
}