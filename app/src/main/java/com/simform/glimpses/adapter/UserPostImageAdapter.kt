package com.simform.glimpses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.databinding.ItemProfilePostImageBinding
import com.simform.glimpses.model.UserPostImage

class UserPostImageAdapter(private val imageList: UserPostImage) :
    RecyclerView.Adapter<UserPostImageAdapter.UserPostImageViewHolder>() {

    class UserPostImageViewHolder(var binding: ItemProfilePostImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userPostImage: Int) {
            binding.imgPost.setImageResource(userPostImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostImageViewHolder {
        val holder = UserPostImageViewHolder(
            ItemProfilePostImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
        return holder
    }

    override fun getItemCount(): Int {
        return imageList.imagePost.size
    }

    override fun onBindViewHolder(holder: UserPostImageViewHolder, position: Int) {
        holder.bind(imageList.imagePost[position])
    }

}