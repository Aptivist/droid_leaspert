package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue


fun String.isValidEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpOutlinedTextFieldMail(
    label: String, hint: String, onEmailValidated: (Boolean) -> Unit ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center

    ) {
        var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                val isValid = it.text.isValidEmail()
                onEmailValidated(isValid)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(label) },
            placeholder = { Text(hint) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            ),
            singleLine = true,
            maxLines = 1,
            shape = MaterialTheme.shapes.small,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            )
        )
    }
}

