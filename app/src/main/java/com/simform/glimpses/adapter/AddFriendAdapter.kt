package com.simform.glimpses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.simform.glimpses.R
import com.simform.glimpses.databinding.ItemAddFriendBinding
import com.simform.glimpses.model.Friend

interface ClickAddFriendListener {
    fun onClickAddFriend()
}

class AddFriendAdapter(
    private val friendList: ArrayList<Friend>,
    private val clickListener: ClickAddFriendListener
) :
    RecyclerView.Adapter<AddFriendAdapter.AddFriendViewHolder>() {

    class AddFriendViewHolder(var binding: ItemAddFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(friend: Friend) {
            binding.apply {
                imgProfileCard.setImageResource(R.drawable.profile_card)
                tvNameCard.text = friend.name
                tvPhoneCard.text = friend.phone
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFriendViewHolder {
        val holder = AddFriendViewHolder(
            ItemAddFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        holder.binding.btnAddCard.setOnClickListener {
            friendList[holder.adapterPosition].isAdded = !friendList[holder.adapterPosition].isAdded

            if (friendList[holder.adapterPosition].isAdded) {
                holder.binding.btnAddCard.apply {
                    setIconResource(R.drawable.done)
                    text = ""
                    iconTint = null
                    iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
                }
            } else {
                holder.binding.btnAddCard.apply {
                    setIconResource(android.R.color.transparent)
                    text = resources.getString(R.string.add)
                    iconTint = null
                    iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
                }
            }
            clickListener.onClickAddFriend()
        }
        return holder
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    override fun onBindViewHolder(holder: AddFriendViewHolder, position: Int) {
        holder.bind(friendList[position])
    }

}