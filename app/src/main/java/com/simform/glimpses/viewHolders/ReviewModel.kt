package com.simform.glimpses.viewHolders

class ReviewModel(val title: String, val subtitle: String?, val list: ArrayList<String>) {

    companion object {
        var reviews = arrayListOf(
            ReviewModel("Would you continue going?", null, arrayListOf("Yes", "No", "Maybe")),
            ReviewModel("What was the vibe?", null, arrayListOf("Calm", "Neutral", "Energetic")),
            ReviewModel(
                "Who is {Business Name} perfect for?",
                "Select All that apply",
                arrayListOf(
                    "Families",
                    "Singles",
                    "Couples",
                    "Eating",
                    "Drinking",
                    "Karaoke",
                    "Dancing"
                )
            ),
        )
    }

}