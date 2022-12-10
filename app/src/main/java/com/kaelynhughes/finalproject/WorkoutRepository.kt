package com.kaelynhughes.finalproject

import androidx.room.Room
import com.kaelynhughes.finalproject.models.Workout

object WorkoutRepository {
    private val db: AppDatabase;
    private var cacheInitialized = false;
    private val workoutsCache = mutableListOf<Workout>()
    init {
        db = Room.databaseBuilder(
            WorkoutsApplication.getInstance(),
            AppDatabase::class.java,
            "workouts-database"
        ).build()
    }

    suspend fun createWorkout(workout: Workout) {
        workout.id = db.getWorkoutsDao().createWorkout(workout)
        workoutsCache.add(workout)
    }

    suspend fun getAllWorkouts(): List<Workout> {
        if (!cacheInitialized) {
            workoutsCache.addAll(db.getWorkoutsDao().getAllWorkouts())
            cacheInitialized = true
        }
        return workoutsCache
    }

    suspend fun update(workout: Workout) {
        db.getWorkoutsDao().updateWorkout(workout)
        workoutsCache[workoutsCache.indexOfFirst {
            it.id == workout.id
        }] = workout
    }
}