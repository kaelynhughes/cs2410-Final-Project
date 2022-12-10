package com.kaelynhughes.finalproject.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(
    @PrimaryKey var id: Long,
    @ColumnInfo val description: String,
    @ColumnInfo val date: String,
    @ColumnInfo val weight: Int,
    @ColumnInfo val reps: Int
)
