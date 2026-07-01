package com.example.homework3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.homework3.data.GameModel
import com.example.homework3.data.GamesRepository
import com.example.homework3.ui.MyTextField

@Composable
fun MainScreen(
    objectsList: MutableList<GameModel>,
    onNavigateToList: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember { mutableStateOf("") }
        MyTextField(value = text, valueChange = { newValue -> text = newValue }, labelText = "Введите число от 1 до 10")

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Row {
            Button(
                onClick = {
                    val listSize = text.toIntOrNull() ?: 1
                    objectsList.clear()
                    objectsList.addAll(GamesRepository.games.shuffled().take(listSize))
                },
                enabled = (text.toIntOrNull() != null && text.toInt() in 1..10),
                modifier = Modifier.size(width = 160.dp, height = 50.dp)
            ) { Text("Сгенерировать") }

            Spacer(modifier = Modifier.padding(horizontal = 8.dp))

            Button(
                onClick = onNavigateToList,
                enabled = objectsList.isNotEmpty(),
                modifier = Modifier.size(width = 160.dp, height = 50.dp)
            ) {
                Text("Список игр")
            }
        }
    }
}