package pe.edu.upc.a01_demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.a01_demoapp.ui.theme._01DemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _01DemoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    // Crear un estado
    val searchText = remember {
        mutableStateOf("") // Es un valor que puede cambiar.
    }

    val isFavorite = remember {
        mutableStateOf(false)
    }

    Scaffold { newPadding ->
        Column {
            Text(
                text = "Hello $name!",
                modifier = modifier.padding(newPadding)
            )
            Text(text = "Mauricio")
            OutlinedTextField(value = searchText.value, onValueChange = { newString ->
                searchText.value = newString
            } )
            IconButton(onClick = {
                isFavorite.value = !isFavorite.value
            }) {
                Icon(
                    Icons.Filled.Favorite,
                    "Favorite",
                    tint = if(isFavorite.value)  Color.Red else Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _01DemoAppTheme {
        Greeting("Android")
    }
}