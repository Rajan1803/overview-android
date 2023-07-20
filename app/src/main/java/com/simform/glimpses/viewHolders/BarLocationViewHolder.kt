package com.simform.glimpses.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.R
import com.simform.glimpses.model.Location

sealed class BarLocationViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    class BarViewHolder(view: View) : BarLocationViewHolder(view)

    class LocationViewHolder(val view: View) : BarLocationViewHolder(view) {
        fun bind(location: Location) {
            view.findViewById<TextView>(R.id.txtvLocTitle).text = location.name
            view.findViewById<TextView>(R.id.txtvSubtitle).text = location.businessName
        }
    }
}