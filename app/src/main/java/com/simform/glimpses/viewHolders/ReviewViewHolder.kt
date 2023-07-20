package com.simform.glimpses.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

sealed class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    class TitleReviewViewHolder(view: View) : ReviewViewHolder(view)
    class SubtitleReviewHolder(view: View) : ReviewViewHolder(view)
}

