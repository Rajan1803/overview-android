package com.simform.glimpses.model

import com.simform.glimpses.R

data class UserPostImage(
    val imagePost: ArrayList<Int>
) {
    companion object {
        val imageList = arrayListOf<UserPostImage>(
            UserPostImage(arrayListOf(R.drawable.profilebg, R.drawable.profilepic)),
            UserPostImage(arrayListOf(R.drawable.forward, R.drawable.peeks)),
            UserPostImage(arrayListOf(R.drawable.post, R.drawable.peeks)),
        )
    }
}
