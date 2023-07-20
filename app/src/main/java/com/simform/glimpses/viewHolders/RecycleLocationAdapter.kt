package com.simform.glimpses.viewHolders

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.R
import com.simform.glimpses.model.Location

class RecycleLocationAdapter : RecyclerView.Adapter<BarLocationViewHolder>() {


    var visibleLocation = Location.locations
    private var numberOfItems = visibleLocation.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarLocationViewHolder {
        when (viewType) {
            R.layout.recycleview_bar -> {
                val barHolder = BarLocationViewHolder.BarViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycleview_bar, parent, false)
                )
                barHolder.itemView.findViewById<TextView>(R.id.txtvAddLocation).setOnClickListener {
                    numberOfItems++
                    notifyDataSetChanged()

                }
                barHolder.itemView.findViewById<androidx.appcompat.widget.SearchView>(R.id.searchViewLocation)
                    .setOnQueryTextListener(object :
                        androidx.appcompat.widget.SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return true
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            visibleLocation = Location.locations.filter { location ->
                                if (newText != null) {
                                    location.name.lowercase().contains(newText.lowercase())
                                } else {
                                    false
                                }
                            } as? ArrayList<Location> ?: Location.locations

                            notifyItemRangeChanged(1, visibleLocation.size)
                            return false
                        }

                    })

                return barHolder
            }

            R.layout.recycleview_locations -> {
                return BarLocationViewHolder.LocationViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycleview_locations, parent, false)
                )
            }

            else -> throw IllegalArgumentException()
        }

    }

    override fun onBindViewHolder(holder: BarLocationViewHolder, position: Int) {
        when (holder) {

            is BarLocationViewHolder.LocationViewHolder -> {
                holder.bind(visibleLocation[position - 1])
            }

            else -> {}
        }
    }

    override fun getItemCount(): Int {

        Log.d("count", visibleLocation.size.toString())
        return visibleLocation.size + 1

    }

    override fun getItemViewType(position: Int): Int {
        Log.d("tag", "getItemViewType:")
        return if (position == 0) {
            R.layout.recycleview_bar
        } else {
            R.layout.recycleview_locations
        }
    }
}
