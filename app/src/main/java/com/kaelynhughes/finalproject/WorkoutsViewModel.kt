package com.kaelynhughes.finalproject

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaelynhughes.finalproject.models.Workout

class WorkoutsViewModel: ViewModel() {
    var errorMessage = MutableLiveData("")
    val workouts = ObservableArrayList<Workout>()
    fun createWorkout(descriptionInput: String) {
        errorMessage.value = ""
        if (descriptionInput.isEmpty()) {
            errorMessage.value = "Input cannot be blank."
            return
        }
        workouts.add(Workout(0, descriptionInput, "date", 0, 0))
        println(descriptionInput)
    }
}