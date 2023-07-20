package com.simform.glimpses.helper

object Validator {

    fun validateEmail(email: String): Boolean {
        return email.matches(Constant.emailPattern.toRegex())
    }

    fun validateName(name: String): Boolean {
        return name.matches(Constant.namePattern.toRegex()) && name.length > 3
    }

}