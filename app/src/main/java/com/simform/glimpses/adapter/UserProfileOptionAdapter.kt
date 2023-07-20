package com.simform.glimpses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simform.glimpses.databinding.ItemUserProfileBinding
import com.simform.glimpses.model.UserProfileOptions

class UserProfileOptionAdapter(private val optionList: ArrayList<UserProfileOptions>) :
    RecyclerView.Adapter<UserProfileOptionAdapter.UserProfileOptionViewHolder>() {

    var onClick: ((UserProfileOptions) -> Unit)? = null

    class UserProfileOptionViewHolder(var binding: ItemUserProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userProfileOptions: UserProfileOptions) {
            binding.apply {
                imgLogo.setImageResource(userProfileOptions.imgLogo)
                tvItemName.text = userProfileOptions.itemName
                imgForward.setImageResource(userProfileOptions.imgForward)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileOptionViewHolder {
        val holder = UserProfileOptionViewHolder(
            ItemUserProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        holder.binding.cardViewProfileOption.setOnClickListener {
            onClick?.let { it1 -> it1(optionList[holder.adapterPosition]) }
        }
        return holder
    }

    override fun getItemCount(): Int {
        return optionList.size
    }

    override fun onBindViewHolder(holder: UserProfileOptionViewHolder, position: Int) {
        holder.bind(optionList[position])
    }

}