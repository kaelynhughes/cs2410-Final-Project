package com.kaelynhughes.finalproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kaelynhughes.finalproject.models.Workout

@Dao
interface WorkoutsDao {
    @Insert
    suspend fun createWorkout(workout: Workout): Long

    @Update
    suspend fun updateWorkout(workout: Workout)

    @Query("SELECT * FROM workout")
    suspend fun getAllWorkouts(): List<Workout>

    @Query("SELECT date FROM workout")
    suspend fun getAllDates(): List<String>
}