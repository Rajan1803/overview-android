package com.simform.glimpses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.databinding.RecyleviewIntrestBinding
import com.simform.glimpses.model.InterestModel

/**
 * interface for ButtonClick Event
 */
interface ButtonClick {
    fun onButtonClick(selectedNumber: Int)
}

class RecycleInterestAdapter(private val interestList: ArrayList<InterestModel>) :
    RecyclerView.Adapter<RecycleInterestAdapter.ViewHolder>() {

    /**
     * variables
     */
    lateinit var delegate: ButtonClick

    lateinit var binding: RecyleviewIntrestBinding

    class ViewHolder(val binding: RecyleviewIntrestBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val holder = ViewHolder(
            RecyleviewIntrestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        holder.binding.imgIntrest.setOnClickListener {
            interestList[holder.adapterPosition].isSelected =
                !interestList[holder.adapterPosition].isSelected
            val elements = interestList.filter { element ->
                element.isSelected
            }
            notifyItemChanged(holder.adapterPosition)
            delegate.onButtonClick(elements.size)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return interestList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.interest = InterestModel.listOfInterests[position]
        holder.binding.imgCheckmark.isVisible = interestList[position].isSelected
    }

}