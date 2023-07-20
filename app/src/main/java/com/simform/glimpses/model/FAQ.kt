package com.simform.glimpses.model

data class FAQ(
    val headingTitle: String,
    val subListTitle: ArrayList<String>
) {
    companion object {
        val faqList = arrayListOf<FAQ>(
            FAQ(
                "How to make a website", arrayListOf(
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                )
            ), FAQ(
                "How to start an online store", arrayListOf(
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                )
            ), FAQ(
                "How to start a blog", arrayListOf(
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                )
            ), FAQ(
                "How to profile picture", arrayListOf(
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                    "Choose a template and start a free trial",
                )
            )
        )
    }
}
