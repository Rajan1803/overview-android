package com.simform.glimpses.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.R

class InnerRecyclerAdapter(private val outerPosition: Int) :
    RecyclerView.Adapter<InnerRecyclerAdapter.InnerRecyclerHolder>() {
    class InnerRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerRecyclerHolder {

        return InnerRecyclerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.review_inner_recyclerview, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return ReviewModel.reviews[outerPosition].list.size
    }

    override fun onBindViewHolder(holder: InnerRecyclerHolder, position: Int) {
        val btnChoose = holder.itemView.findViewById<Button>(R.id.btnChoose)
        btnChoose.text =
            ReviewModel.reviews[outerPosition].list[position]
        btnChoose.setOnClickListener {
            btnChoose.isSelected =
                !btnChoose.isSelected
        }
    }
}