package com.example.digitalx4.features.service_report.presentation.add_edit_report.components

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ServiceReportInputField(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    value:String = "",
    onValueChange:(String)->Unit = {},
    onImeAction: () -> Unit = {},
    maxLine: Int = 1,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Number,
    readOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null
){
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = value,
        singleLine = true,
        onValueChange = onValueChange,
        maxLines = maxLine,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            textColor = MaterialTheme.colorScheme.onSurface,
            placeholderColor = MaterialTheme.colorScheme.primary
        ),

        label = {
            Text(
                text = stringResource(id = label),
                style = MaterialTheme.typography.bodyMedium


            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(

            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        ),
        modifier = modifier,
        readOnly = readOnly,
        trailingIcon = trailingIcon

    )


}