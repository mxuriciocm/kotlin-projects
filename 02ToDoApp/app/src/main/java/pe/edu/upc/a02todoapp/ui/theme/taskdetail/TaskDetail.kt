package pe.edu.upc.a02todoapp.ui.theme.taskdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TaskDetail() {

    val task = remember {
        mutableStateOf("")
    }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Done, contentDescription = "Done" )
            }
        }
    ){ paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)) {
            OutlinedTextField(value = task.value, modifier = Modifier.fillMaxWidth(), onValueChange = { newValue ->
                task.value = newValue
            })

        }
    }
}



@Preview
@Composable
fun TaskDetailPreview() {
    TaskDetail()
}