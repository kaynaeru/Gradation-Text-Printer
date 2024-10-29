package com.example.tugas_gslc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugas_gslc.ui.theme.Tugas_gslcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            Tugas_gslcTheme() {
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
    var teksInput by remember { mutableStateOf("") } //untuk teks input dari user
    val teksTampil = remember { mutableStateOf(false) } //boolean state teks muncul atau tidak

    Column(
        modifier = Modifier.fillMaxSize(), // seukuran layar
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        TextField(
            value = teksInput,
            onValueChange = { teksInput = it }, //teksInput --> it
            label = { Text("Insert your name") }
        )
        Button(
            onClick = {
                teksTampil.value = true
            },
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text("Next")
        }
        if (teksTampil.value) {
            val gradientColor = Brush.linearGradient(colors = listOf(Color.Blue, Color.Magenta))
            Text(
                text = teksInput,
                fontSize = 30.sp,
                style = TextStyle(brush = gradientColor)
            )
        }
    }
}

