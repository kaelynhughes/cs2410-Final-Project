package com.kaelynhughes.finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo var description: String,
    @ColumnInfo var date: String,
    @ColumnInfo var weight: Int,
    @ColumnInfo var reps: Int
)
