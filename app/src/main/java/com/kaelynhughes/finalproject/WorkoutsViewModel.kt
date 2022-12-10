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
    fun createWorkout(dateInput: String, descriptionInput: String, weightInput: Int, repsInput: Int) {
        errorMessage.value = ""
        if (dateInput.isEmpty() || descriptionInput.isEmpty()) {
            errorMessage.value = "Input cannot be blank."
            return
        }

        viewModelScope.launch {
            val workout = Workout(id = 0, description = descriptionInput, date = dateInput, weight = weightInput, reps = repsInput)
            workout.id = WorkoutRepository.createWorkout(workout)
            workouts.add(workout)
        }

        println(descriptionInput)
    }


}