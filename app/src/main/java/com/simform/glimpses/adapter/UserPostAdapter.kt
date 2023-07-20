package com.simform.glimpses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.simform.glimpses.databinding.ItemProfiePostImagelessBinding
import com.simform.glimpses.databinding.ItemProfilePostBinding
import com.simform.glimpses.model.UserPost

enum class ViewTypes {
    WITHIMAGE,
    WITHOUTIMAGE
}

class UserPostAdapter(private val postList: ArrayList<UserPost>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class UserPostViewHolder(var binding: ItemProfilePostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userPost: UserPost) {
            binding.apply {
                imgProfile.setImageResource(userPost.imgUser)
                tvName.text = userPost.name
                tvUserName.text = userPost.userName
                tvTime.text = userPost.time
                tvDesc.text = userPost.desc
                tvLike.text = userPost.txtLike
                tvComment.text = userPost.txtComment
                tvShare.text = userPost.txtShare

                rvPost.layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                userPost.imgPost?.let {
                    val adapter = UserPostImageAdapter(it)
                    rvPost.adapter = adapter
                }

                val snapHelper: SnapHelper = LinearSnapHelper()
                rvPost.onFlingListener = null
                snapHelper.attachToRecyclerView(rvPost)

            }
        }

    }

    class UserPostImageLessViewHolder(var binding: ItemProfiePostImagelessBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userPost: UserPost) {
            binding.apply {
                imgProfile.setImageResource(userPost.imgUser)
                tvName.text = userPost.name
                tvUserName.text = userPost.userName
                tvTime.text = userPost.time
                tvDesc.text = userPost.desc
                tvLike.text = userPost.txtLike
                tvComment.text = userPost.txtComment
                tvShare.text = userPost.txtShare
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val holder = when (viewType) {
            ViewTypes.WITHIMAGE.ordinal -> UserPostViewHolder(
                ItemProfilePostBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            ViewTypes.WITHOUTIMAGE.ordinal -> UserPostImageLessViewHolder(
                ItemProfiePostImagelessBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            else -> UserPostViewHolder(
                ItemProfilePostBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
        return holder
    }

    override fun getItemViewType(position: Int): Int {
        return if (postList[position].imgPost != null) 0 else 1
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0) {
            (holder as UserPostViewHolder).bind(postList[position])
        } else {
            (holder as UserPostImageLessViewHolder).bind(postList[position])
        }
    }

}