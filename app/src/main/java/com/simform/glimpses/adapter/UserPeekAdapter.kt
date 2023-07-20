package com.simform.glimpses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.databinding.ItemProfilePeekBinding
import com.simform.glimpses.model.UserPeek

class UserPeekAdapter(private val peekList: ArrayList<UserPeek>) :
    RecyclerView.Adapter<UserPeekAdapter.UserPeeksViewHolder>() {

    class UserPeeksViewHolder(var binding: ItemProfilePeekBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userPeek: UserPeek) {
            binding.apply {
                imgPeeks.setImageResource(userPeek.peek)
                tvTime.text = userPeek.duration
                tvPostedTime.text = userPeek.postedTime
                tvUserName.text = userPeek.userName
                imgProfile.setImageResource(userPeek.imgProfile)
            }
            bindCount++
        }

        companion object {
            var createCount = 0
            var bindCount = 0
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPeeksViewHolder {
        UserPeeksViewHolder.createCount++
        val holder = UserPeeksViewHolder(
            ItemProfilePeekBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
        holder.binding.imgPeeks.setOnClickListener {
            Toast.makeText(
                parent.context,
                "Bind Count: ${UserPeeksViewHolder.bindCount}" + "Create Count: ${UserPeeksViewHolder.createCount}",
                Toast.LENGTH_SHORT

            ).show()
        }
        return holder
    }

    override fun getItemCount(): Int {
        return peekList.size
    }

    override fun onBindViewHolder(holder: UserPeeksViewHolder, position: Int) {
        holder.bind(peekList[position])
    }

}