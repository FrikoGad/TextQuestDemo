package com.example.textquest

interface Repository {

    fun nextStep(id: String) : ScreenUI
}