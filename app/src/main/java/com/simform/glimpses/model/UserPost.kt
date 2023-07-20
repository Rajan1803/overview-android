package com.simform.glimpses.model

import com.simform.glimpses.R

data class UserPost(
    val imgUser: Int,
    val name: String,
    val userName: String,
    val time: String,
    val desc: String,
    val imgPost: UserPostImage? = null,
    val txtLike: String,
    val txtComment: String,
    val txtShare: String,
) {
    companion object {
        val postList = arrayListOf<UserPost>(
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                UserPostImage.imageList[0],
                "2K",
                "89",
                "43"
            ),
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                null,
                "2K",
                "89",
                "43"
            ),
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                null,
                "2K",
                "89",
                "43"
            ),
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                UserPostImage.imageList[1],
                "2K",
                "89",
                "43"
            ),
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                UserPostImage.imageList[1],
                "2K",
                "89",
                "43"
            ),
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                UserPostImage.imageList[0],
                "2K",
                "89",
                "43"
            ),
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                UserPostImage.imageList[2],
                "2K",
                "89",
                "43"
            ),
            UserPost(
                R.drawable.profilepic,
                "Tianaa",
                "@tianaa389",
                "21h",
                "This is post description",
                UserPostImage.imageList[0],
                "2K",
                "89",
                "43"
            ),
        )
    }
}
