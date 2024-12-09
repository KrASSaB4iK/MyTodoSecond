package com.example.mytodo.presentaiton

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodo.data.repository.TaskRepository
import com.example.mytodo.model.TaskEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TaskRepository
): ViewModel() {
    var taskEntity:TaskEntity by mutableStateOf(TaskEntity(id = 0, isImportant = false, task = "", typeTask = "WorkTask"))
        private set

    val getAllTask: Flow<List<TaskEntity>> = repository.getAllTask()

    private var deleteTodo: TaskEntity? = null

    fun insertTask(task: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTask(taskEntity = task)
        }
    }

    fun updateTask(task: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(taskEntity = task)
        }
    }

    fun deleteTask(task: TaskEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(taskEntity = task)
        }
    }

//    fun undoDeleted() {
//        deleteTodo?.let { taskEntity ->
//            viewModelScope.launch(Dispatchers.IO) {
//                repository.insertTask(taskEntity = ta)
//            }
//        }
//    }

    fun getTaskById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            taskEntity = repository.getTaskById(id = id)
            taskEntity = repository.getTaskById(id = id)
        }
    }

    fun updateTaskText(newValue: String) {
        taskEntity = taskEntity.copy(task = newValue)
    }

    fun updateIsImportant(newValue: Boolean) {
        taskEntity = taskEntity.copy(isImportant = newValue)
    }
}