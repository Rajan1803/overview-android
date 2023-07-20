package com.simform.glimpses.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.R
import com.simform.glimpses.adapter.GlimpsesItemDecoration

class OuterRecyclerAdapter : RecyclerView.Adapter<OuterRecyclerAdapter.TitleViewHolder>() {

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {


        return TitleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.review_outer_recyclerview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return ReviewModel.reviews.size
    }

    override fun onBindViewHolder(viewholder: TitleViewHolder, position: Int) {

        val itemdecorations = GlimpsesItemDecoration(verticalSpace = 24, horizontalSpace = 24)
        val innerRecyclerView =
            viewholder.itemView.findViewById<RecyclerView>(R.id.reccyclerViewInner)
        innerRecyclerView.layoutManager = GridLayoutManager(viewholder.itemView.context, 3)
        innerRecyclerView.adapter = InnerRecyclerAdapter(position)
        innerRecyclerView.addItemDecoration(itemdecorations)

        val txtvTitle = viewholder.itemView.findViewById<TextView>(R.id.textView)
        val txtvSubtitle = viewholder.itemView.findViewById<TextView>(R.id.txtvSubtitle)
        if (ReviewModel.reviews[position].subtitle == null) {
            txtvTitle.text =
                ReviewModel.reviews[position].title
            txtvSubtitle.visibility = View.GONE

        } else {
            txtvTitle.visibility = View.VISIBLE
            txtvTitle.text =
                ReviewModel.reviews[position].title
            txtvSubtitle.text =
                ReviewModel.reviews[position].subtitle
        }

    }
}