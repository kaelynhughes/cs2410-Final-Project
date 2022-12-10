package com.kaelynhughes.finalproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kaelynhughes.finalproject.models.Workout

@Dao
interface WorkoutsDao {
    @Query("SELECT * FROM workout")
    suspend fun getAllWorkouts(): List<Workout>

    @Insert
    suspend fun createWorkout(workout: Workout): Long

    @Update
    suspend fun updateTodo(workout: Workout)
}