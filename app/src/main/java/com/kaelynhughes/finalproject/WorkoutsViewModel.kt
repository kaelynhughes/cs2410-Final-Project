package com.kaelynhughes.finalproject

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

var idCounter = 0

class WorkoutsViewModel: ViewModel() {
    val workouts = ObservableArrayList<Workout>()
    var errorMessage = MutableLiveData("")
    init {
        loadWorkouts()
    }

    private fun loadWorkouts() {
        viewModelScope.launch {
            val loadedWorkouts = WorkoutRepository.getAllWorkouts()
            workouts.addAll(loadedWorkouts)
        }
    }

    fun createWorkout(dateInput: String, typeInput: String, weightInput: Int, repsInput: Int) {
        errorMessage.value = ""
        if (dateInput.isEmpty() || typeInput.isEmpty()) {
            errorMessage.value = "Inputs cannot be blank."
            viewModelScope.launch {
                delay(3000)
                errorMessage.value = ""
            }
            return
        }
        if(dateInput.trim().isEmpty() || typeInput.trim().isEmpty()) {
            errorMessage.value = "Inputs must not be empty."
            viewModelScope.launch {
                delay(3000)
                errorMessage.value = ""
            }
            return
        }

        viewModelScope.launch {
            val workout = Workout(id = 0, description = typeInput, date = dateInput, weight = weightInput, reps = repsInput)
            WorkoutRepository.createWorkout(workout)
            workouts.add(workout)
        }
    }
}