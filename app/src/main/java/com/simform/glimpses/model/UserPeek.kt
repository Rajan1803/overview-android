package com.simform.glimpses.model

import com.simform.glimpses.R

data class UserPeek(
    val peek: Int,
    val duration: String,
    val postedTime: String,
    val imgProfile: Int,
    val userName: String
) {
    companion object {
        val userPeekList = arrayListOf<UserPeek>(
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
            UserPeek(R.drawable.peeks, "45s", "2h ago", R.drawable.profilepic, "Tianaa"),
        )
    }
}

