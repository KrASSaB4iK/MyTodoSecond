package com.example.mytodo.model


sealed class Task(id: Int, isImportant: Boolean, task: String) {
    data class WorkTask(
        val id: Int,
        val isImportant: Boolean,
        val task: String
    ) : Task(
        id = id,
        isImportant = isImportant,
        task = task
    )
    data class HomeTask(
        val id: Int,
        val isImportant: Boolean,
        val task: String
    ) : Task(
        id = id,
        isImportant = isImportant,
        task = task
    )
}