package pe.edu.upc.a02todoapp.ui.theme.tasklist

import android.content.ClipData.Item
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


// Create a new composable function
@Composable
fun TaskList() {
    
    val tasks = remember {
        mutableStateOf(emptyList<String>())
    }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = {
                tasks.value += "hola"

            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
                
            }
        },
    ){ paddingValues ->
        LazyColumn (modifier = Modifier.padding(paddingValues)) {
            items(tasks.value) { task ->
                Text(task)
            }
        }
    }
}


// Show a preview of the composable
@Preview
@Composable
fun TaskListPreview() {
    TaskList()
}