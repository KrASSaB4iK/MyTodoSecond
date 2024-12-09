package com.example.mytodo.model

fun returnTask(taskEntity: TaskEntity) : Task{
    if (taskEntity.typeTask == "WorkTask"){
        return Task.WorkTask(taskEntity.id, taskEntity.isImportant, taskEntity.task)
    }
    else {
        return Task.HomeTask(taskEntity.id, taskEntity.isImportant, taskEntity.task)
    }
}