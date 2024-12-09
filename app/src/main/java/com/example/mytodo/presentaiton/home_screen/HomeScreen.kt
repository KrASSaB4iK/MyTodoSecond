package com.example.mytodo.presentaiton.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mytodo.R
import com.example.mytodo.model.returnTask
import com.example.mytodo.presentaiton.MainViewModel
import com.example.mytodo.presentaiton.common.mySnackbar
import com.example.mytodo.presentaiton.common.topAppBarTextStyle
import com.example.mytodo.presentaiton.home_screen.components.AlertDialog_HomeSc
import com.example.mytodo.presentaiton.home_screen.components.EmptyTaskScreen
import com.example.mytodo.presentaiton.home_screen.components.TaskCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    onUpdate: (id: Int) -> Unit
) {
    val tasks by
    mainViewModel.getAllTask.collectAsStateWithLifecycle(initialValue = emptyList())
    var openDialog by remember {
        mutableStateOf(false)
    }
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(title = {
                Text(
                    text = stringResource(R.string.top_bar),
                    style = topAppBarTextStyle
                )
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {openDialog = true}) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null
                )
            }
        }
    ){ paddingValues ->
        AlertDialog_HomeSc(
            openDialog = openDialog,
            onClose = {openDialog = false},
            mainViewModel = mainViewModel
        )
        if(tasks.isEmpty()) {
            EmptyTaskScreen(paddingValues = paddingValues)
        } else{
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = tasks,
                    key = {it.id}
                ) {
                        task ->
                    TaskCard(
                        task = returnTask(taskEntity = task),
                        onDone = {
                            mainViewModel.deleteTask(task = task)
                        },
                        onUpdate = onUpdate
                    )
                }
            }
        }
    }
}