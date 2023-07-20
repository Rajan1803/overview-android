package com.simform.glimpses.adapter

import android.app.TimePickerDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.databinding.ItemTimeWeekBuisnessHourBinding
import com.simform.glimpses.helper.Constant
import com.simform.glimpses.model.WeekTime
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class WeekTimeAdapter(
    private val onWeekTimeClickListener: OnWeekTimeClickListener
) : ListAdapter<WeekTime, WeekTimeAdapter.WeekTimeViewHolder>(WeekTimeDiffCallBack()) {

    inner class WeekTimeViewHolder(var binding: ItemTimeWeekBuisnessHourBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val mCurrentTimeFrom: Calendar = Calendar.getInstance()
        val mCurrentTimeTo: Calendar = Calendar.getInstance()

        fun bind(weekTime: WeekTime) {
            binding.apply {
                etFromTime.setText(getFormattedDate(weekTime.fromTime))
                etToTime.setText(getFormattedDate(weekTime.toTime))
            }
        }

        fun updateTimeSelected(editText: EditText, currentTime: Calendar) {
            editText.setText(getFormattedDate(currentTime.time))
        }

        private fun getFormattedDate(date: Date?): String? {
            val dateFormat = SimpleDateFormat(Constant.businessWeekTimeFormat, Locale.getDefault())
            return date?.let { dateFormat.format(it) }
        }

    }

    private class WeekTimeDiffCallBack : DiffUtil.ItemCallback<WeekTime>() {
        override fun areItemsTheSame(oldItem: WeekTime, newItem: WeekTime): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: WeekTime, newItem: WeekTime): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekTimeViewHolder {
        val holder = WeekTimeViewHolder(
            ItemTimeWeekBuisnessHourBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        holder.apply {
            binding.btnTimeDelete.setOnClickListener {
                onWeekTimeClickListener.onDelete(currentList[adapterPosition], this@WeekTimeAdapter)
            }
            binding.etFromTime.setOnClickListener {
                val hourCalender = mCurrentTimeFrom.get(Calendar.HOUR_OF_DAY)
                val minuteCalender = mCurrentTimeFrom.get(Calendar.MINUTE)
                TimePickerDialog(parent.context, { _, hourOfDay, minute ->
                    mCurrentTimeFrom.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    mCurrentTimeFrom.set(Calendar.MINUTE, minute)
                    updateTimeSelected(binding.etFromTime, mCurrentTimeFrom)
                    currentList[adapterPosition].fromTime = mCurrentTimeFrom.time
                }, hourCalender, minuteCalender, false).show()
            }
            binding.etToTime.setOnClickListener {
                val hour = mCurrentTimeTo.get(Calendar.HOUR_OF_DAY)
                val minute = mCurrentTimeTo.get(Calendar.MINUTE)
                TimePickerDialog(parent.context, { _, hourOfDay, minute ->
                    mCurrentTimeTo.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    mCurrentTimeTo.set(Calendar.MINUTE, minute)
                    updateTimeSelected(holder.binding.etToTime, mCurrentTimeTo)
                    currentList[adapterPosition].toTime = mCurrentTimeTo.time
                }, hour, minute, false).show()
            }
        }
        return holder
    }

    override fun submitList(list: MutableList<WeekTime>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: WeekTimeViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}

fun interface OnWeekTimeClickListener {
    fun onDelete(weekTime: WeekTime, position: WeekTimeAdapter)
}