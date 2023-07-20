package com.simform.glimpses.model

import com.simform.glimpses.R

data class UserProfileOptions(
    val imgLogo: Int,
    val itemName: String,
    val imgForward: Int
) {
    companion object {
        val optionList = arrayListOf<UserProfileOptions>(
            (UserProfileOptions(R.drawable.lists, "Lists", R.drawable.forward)),
            (UserProfileOptions(R.drawable.map, "My Journey Map", R.drawable.forward)),
            (UserProfileOptions(R.drawable.events, "Saved Events", R.drawable.forward)),
            (UserProfileOptions(R.drawable.offers, "My Offers", R.drawable.forward)),
            (UserProfileOptions(R.drawable.contacts, "Saved Content", R.drawable.forward)),
            (UserProfileOptions(R.drawable.contacts, "Contact Us", R.drawable.forward)),
            (UserProfileOptions(R.drawable.events, "FAQ", R.drawable.forward)),
        )
    }
}