package com.example.mytodo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytodo.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 2, exportSchema = true)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}