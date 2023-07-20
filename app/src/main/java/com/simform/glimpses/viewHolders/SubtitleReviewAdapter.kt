package com.simform.glimpses.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.R

class SubtitleReviewAdapter : RecyclerView.Adapter<SubtitleReviewAdapter.SubtitleViewHolder>() {

    class SubtitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubtitleViewHolder {
        return SubtitleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_outer_subtitle, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: SubtitleViewHolder, position: Int) {

    }

}