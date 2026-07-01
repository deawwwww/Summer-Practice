package com.example.homework3.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun MyTextField(value: String, labelText: String, valueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { valueChange(it) },
        label = { Text(labelText) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}