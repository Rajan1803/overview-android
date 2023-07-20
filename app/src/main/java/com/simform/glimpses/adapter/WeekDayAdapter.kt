package com.simform.glimpses.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.databinding.ItemWeekBusinessHourBinding
import com.simform.glimpses.model.WeekDay
import com.simform.glimpses.model.WeekTime

class WeekDayAdapter :
    ListAdapter<WeekDay, WeekDayAdapter.WeekDayViewHolder>(WeekDayDiffCallBack()) {

    class WeekDayDiffCallBack : DiffUtil.ItemCallback<WeekDay>() {
        override fun areItemsTheSame(oldItem: WeekDay, newItem: WeekDay): Boolean =
            oldItem.day == newItem.day

        override fun areContentsTheSame(oldItem: WeekDay, newItem: WeekDay): Boolean =
            oldItem == newItem

    }

    inner class WeekDayViewHolder(var binding: ItemWeekBusinessHourBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weekDay: WeekDay) {
            binding.apply {
                tvDayOfWeek.text = weekDay.day
                switchWeek.isChecked = weekDay.isExpanded
                selectDateGroup.visibility = if (weekDay.isExpanded) View.VISIBLE else View.GONE
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekDayViewHolder {
        val holder = WeekDayViewHolder(
            ItemWeekBusinessHourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        holder.binding.apply {
            rvWeekTime.layoutManager = LinearLayoutManager(parent.context)
            switchWeek.setOnCheckedChangeListener { _, checked ->
                currentList[holder.adapterPosition].let { weekDay ->
                    weekDay.isExpanded = checked
                    selectDateGroup.visibility =
                        if (weekDay.isExpanded) View.VISIBLE else View.GONE
                    val weekTimeAdapter = WeekTimeAdapter() { weekTime, adapter ->
                        weekDay.weekTimes.remove(weekTime)
                        adapter.submitList(currentList[holder.adapterPosition].weekTimes)
                        if (weekDay.weekTimes.size < 4) {
                            tvAddHours.isEnabled = true
                            tvAddHours.alpha = 1f
                        }
                    }
                    rvWeekTime.adapter = weekTimeAdapter
                    weekTimeAdapter.submitList(weekDay.weekTimes)
                }
            }
            tvAddHours.setOnClickListener {
                currentList[holder.adapterPosition].apply {
                    if (weekTimes.size < 4) {
                        weekTimes.add(WeekTime())
                        (rvWeekTime.adapter as ListAdapter<WeekTime, WeekTimeAdapter.WeekTimeViewHolder>).submitList(
                            weekTimes
                        )
                        if (weekTimes.size == 4) {
                            tvAddHours.isEnabled = false
                            tvAddHours.alpha = 0.5f
                        }
                    }
                }
            }
        }
        return holder
    }

    override fun submitList(list: MutableList<WeekDay>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: WeekDayViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}