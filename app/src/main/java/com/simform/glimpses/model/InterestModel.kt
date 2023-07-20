package com.simform.glimpses.model

import com.simform.glimpses.R

class InterestModel(val imageId: Int, val title: String, var isSelected: Boolean = false) {

    companion object {
        val listOfInterests = arrayListOf(
            InterestModel(
                R.drawable.interest_bar_image, "Bars &\n" + "Nightlife"
            ),
            InterestModel(R.drawable.interest_art_image, "Arts and Entertainment"),
            InterestModel(R.drawable.interest_food_image, "Food"),
            InterestModel(
                R.drawable.interest_bar_image, "Bars &\n" + "Nightlife"
            ),
            InterestModel(R.drawable.interest_art_image, "Arts and Entertainment"),
            InterestModel(R.drawable.interest_food_image, "Food"),
            InterestModel(
                R.drawable.interest_bar_image, "Bars &\n" + "Nightlife"
            ),
            InterestModel(R.drawable.interest_art_image, "Arts and Entertainment"),
            InterestModel(R.drawable.interest_food_image, "Food"),
            InterestModel(
                R.drawable.interest_bar_image, "Bars &\n" + "Nightlife"
            ),
            InterestModel(R.drawable.interest_art_image, "Arts and Entertainment"),
            InterestModel(R.drawable.interest_food_image, "Food"),
            InterestModel(
                R.drawable.interest_bar_image, "Bars &\n" + "Nightlife"
            ),
            InterestModel(R.drawable.interest_art_image, "Arts and Entertainment"),
            InterestModel(R.drawable.interest_food_image, "Food"),
            InterestModel(
                R.drawable.interest_bar_image, "Bars &\n" + "Nightlife"
            ),
            InterestModel(R.drawable.interest_art_image, "Arts and Entertainment"),
            InterestModel(R.drawable.interest_food_image, "Food")
        )
    }
}