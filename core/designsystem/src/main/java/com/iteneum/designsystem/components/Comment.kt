package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.iteneum.designsystem.theme.LeasePertTheme

/**
 * A component to generate a comment field.
 *
 * @param modifier to modify an specific property of the textfield
 * @param comment: string for user's comment
 * @param hint: Show a hint for the comment.
 * @param onValueChanged: high order function param
 *
 * @author Kevin Velez
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpGenericComment(
    modifier: Modifier = Modifier,
    comment: String,
    hint: String = "Describe your problem...",
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .heightIn(min = LeasePertTheme.sizes.extraSize175)
            .fillMaxWidth()
            .padding(all = LeasePertTheme.sizes.smallSize),
        value = comment,
        onValueChange = onValueChanged,
        singleLine = false,
        placeholder = { Text(text = hint, color = MaterialTheme.colorScheme.tertiary) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorBorderColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error
        ),
    )
}
