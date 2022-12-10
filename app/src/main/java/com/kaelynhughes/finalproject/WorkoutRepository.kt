package com.kaelynhughes.finalproject

import androidx.room.Room
import com.kaelynhughes.finalproject.models.Workout

object WorkoutRepository {
    init {
        Room.databaseBuilder(
            WorkoutsApplication.getInstance(),
            AppDatabase::class.java,
            "workouts-database"
        ).build()
    }
}