package com.example.homework3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.homework3.data.GameModel
import com.example.homework3.ui.MyTextField

@Composable
fun SecondScreen(games: List<GameModel>) {
    var yearInput by remember { mutableStateOf("") }

    var filteredGames by remember { mutableStateOf(games) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField(
            value = yearInput,
            valueChange = { yearInput = it },
            labelText = "Фильтр по году выпуска"
        )

        Spacer(modifier = Modifier.height(8.dp))

        //кнопка сортировки
        Button(
            onClick = {
                if (yearInput.isBlank()) {
                    filteredGames = games
                } else {
                    filteredGames = games.filter { game ->
                        game.releaseDate <= yearInput.toInt()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) { Text("Сортировать") }

        Spacer(modifier = Modifier.height(16.dp))

        //вывод результата сортировки
        if (filteredGames.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Нет результатов")
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredGames) { game ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = game.iconUrl,
                            contentDescription = game.name,
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))

                        Text(text = game.name + " (" + (game.releaseDate) + ")")
                    }
                }
            }
        }
    }
}