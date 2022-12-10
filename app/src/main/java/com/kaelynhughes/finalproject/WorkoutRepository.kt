package com.kaelynhughes.finalproject

import androidx.room.Room
import com.kaelynhughes.finalproject.models.Workout

object WorkoutRepository {
    private val db: AppDatabase
    init {
        db = Room.databaseBuilder(
            WorkoutsApplication.getInstance(),
            AppDatabase::class.java,
            "workouts-database"
        ).build()
    }

    suspend fun createWorkout(workout: Workout): Long {
        return db.getWorkoutsDao().createWorkout(workout)
    }

    suspend fun getAllWorkouts(): List<Workout> {
        return listOf()
    }
}