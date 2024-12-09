package com.example.mytodo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TaskEntity")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val isImportant : Boolean,
    val task : String,
    val typeTask : String
)
