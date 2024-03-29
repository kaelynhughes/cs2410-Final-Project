package com.kaelynhughes.finalproject

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaelynhughes.finalproject.models.Workout
import kotlinx.coroutines.launch

class WorkoutsViewModel: ViewModel() {
    var errorMessage = MutableLiveData("")
    val workouts = ObservableArrayList<Workout>()

    init {
        loadWorkouts()
    }

    fun loadWorkouts() {
        viewModelScope.launch {
            val loadedWorkouts = WorkoutRepository.getAllWorkouts()
            workouts.addAll(loadedWorkouts)
        }
    }

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
            workout.id = WorkoutRepository.createWorkout(workout)
            workouts.add(workout)
        }

        println(descriptionInput)
    }


}