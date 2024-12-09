package com.example.mytodo.presentaiton.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodo.model.Task
import com.example.mytodo.model.TaskEntity
import com.example.mytodo.presentaiton.common.taskText


@Composable
fun TaskCard(
    task: Task,
    onDone: () ->Unit,
    onUpdate: (id: Int) -> Unit
) {
    when (task) {
        is Task.WorkTask -> {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                        .background(Color.Green),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(onClick = { onDone()},
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(imageVector = Icons.Rounded.Check,
                            contentDescription = null
                        )
                    }
                    Text(
                        text = task.task,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(8f),
                        style = taskText
                    )
                    if(task.isImportant) {
                        Icon(
                            imageVector = Icons.Rounded.Star,
                            contentDescription = null,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    IconButton(
                        onClick = {onUpdate(task.id)},
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = null
                        )
                    }
                }
            }
        }
        is Task.HomeTask -> {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                        .background(Color.Yellow),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(onClick = { onDone()},
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(imageVector = Icons.Rounded.Check,
                            contentDescription = null
                        )
                    }
                    Text(
                        text = task.task,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(8f),
                        style = taskText
                    )
                    if(task.isImportant) {
                        Icon(
                            imageVector = Icons.Rounded.Star,
                            contentDescription = null,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    IconButton(
                        onClick = {onUpdate(task.id)},
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}