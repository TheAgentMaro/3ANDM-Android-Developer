package com.supinfo.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.supinfo.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskListScreen()
                }
            }
        }
    }
}


@Composable
fun TaskListScreen() {
    // Créer une instance de TaskList
    val taskList = TaskList()

    // Ajouter quelques tâches à la liste
    taskList.addTask(Task("Faire les courses", "Acheter du lait et du pain", false))
    taskList.addTask(Task("Rédiger un rapport", "Terminez le rapport pour la réunion", false))
    taskList.addTask(Task("Faire de l'exercice", "Faites une séance d'entraînement de 30 minutes", true))

    // Afficher toutes les tâches
    Column(modifier = Modifier.padding(16.dp)) {
        taskList.tasks.forEach { task ->
            TaskItem(
                task = task,
                onDeleteClick = { taskList.removeTask(task) },
                onEditClick = { }
            )
        }
    }
}
@Composable
fun TaskItem(task: Task, onDeleteClick: () -> Unit, onEditClick: () -> Unit) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = task.title)
        Text(text = task.description)
        Button(onClick = onDeleteClick) {
            Text(text = "Supprimer")
        }
        Button(onClick = onEditClick) {
            Text(text = "Modifier")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListScreenPreview() {
    MyApplicationTheme {
        TaskListScreen()
    }
}