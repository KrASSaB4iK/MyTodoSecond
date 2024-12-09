package com.example.mytodo.data.repository

import com.example.mytodo.data.local.TaskDao
import com.example.mytodo.model.Task
import com.example.mytodo.model.TaskEntity
import kotlinx.coroutines.flow.Flow


class TaskRepository(
    private val dao: TaskDao
) {
    suspend fun insertTask(taskEntity: TaskEntity) : Unit = dao.insertTask(taskEntity = taskEntity)
    suspend fun updateTask(taskEntity: TaskEntity) : Unit = dao.updateTask(taskEntity = taskEntity)
    suspend fun deleteTask(taskEntity: TaskEntity) : Unit = dao.deleteTask(taskEntity = taskEntity)
    suspend fun getTaskById(id: Int) : TaskEntity = dao.getTask(id = id)
    fun getAllTask() : Flow<List<TaskEntity>> = dao.getAllTask()
}