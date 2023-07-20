package com.example.doctormobile.helpers

import com.example.doctormobile.model.Doctor

interface OnButtonClick {
    fun onBtnSubmitClick(doctor: Doctor?)
}