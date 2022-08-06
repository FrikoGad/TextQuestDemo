package com.example.textquest

import androidx.lifecycle.MutableLiveData

class MainViewModel(private val repository: Repository) {

    val liveData = MutableLiveData<ScreenUI>()

    fun nextScreen(id: String) {
        val screenUI = repository.nextScreen(id)
        liveData.value = screenUI
    }

}