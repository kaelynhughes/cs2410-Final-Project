package com.kaelynhughes.finalproject

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kaelynhughes.finalproject.models.Workout

@Database(entities = [Workout::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getWorkoutsDao(): WorkoutsDao
}