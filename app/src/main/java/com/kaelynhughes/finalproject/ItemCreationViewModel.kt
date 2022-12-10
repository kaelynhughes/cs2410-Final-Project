package com.kaelynhughes.finalproject

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaelynhughes.finalproject.models.Workout
import kotlinx.coroutines.launch

class ItemCreationViewModel: ViewModel() {
    var errorMessage = MutableLiveData("")

    fun createWorkout(dateInput: String, descriptionInput: String, weightInput: Int, setsInput: Int, repsInput: Int) {
        errorMessage.value = ""
        if (dateInput.isEmpty() || descriptionInput.isEmpty()) {
            errorMessage.value = "Input cannot be blank."
            return
        }
        else if (weightInput.toString().isEmpty() || setsInput.toString().isEmpty() || repsInput.toString().isEmpty()) {
            errorMessage.value = "Input cannot be blank."
            return
        }

        viewModelScope.launch {
            val workout = Workout(id = 0, description = descriptionInput, date = dateInput, weight = weightInput, sets = setsInput, reps = repsInput)
            WorkoutRepository.createWorkout(workout)
        }
    }
}