package com.simform.glimpses.model

data class HeaderTitleModel(val title: String, val subtitle: String?) {

    companion object {
        val titleList = arrayListOf<HeaderTitleModel>(
            HeaderTitleModel("Would you continue going?", null),
            HeaderTitleModel("What was the vibe?", null),
            HeaderTitleModel("Who is {Business Name} perfect for?", "select all that apply")
        )
    }
}