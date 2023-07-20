package com.simform.glimpses.model

import com.simform.glimpses.R

data class Friend(
    val image: Int,
    val name: String,
    val phone: String,
    var isAdded: Boolean = false
) {
    companion object {
        val friendList = arrayListOf<Friend>(
            (Friend(R.drawable.profile_card, "Christofer Jay", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer Sagar", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer Rajan", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
            (Friend(R.drawable.profile_card, "Christofer George", "123-456-789 • Invite via SMS")),
        )
    }
}

