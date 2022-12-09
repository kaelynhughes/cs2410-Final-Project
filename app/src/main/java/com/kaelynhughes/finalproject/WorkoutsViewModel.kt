package com.kaelynhughes.finalproject

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class WorkoutsViewModel: ViewModel() {
    var hasError = MutableLiveData(false)
    fun createWorkout(descriptionInput: String) {
        if (descriptionInput.isEmpty()) {
            hasError.value = true
        }
        println(descriptionInput)
    }
}