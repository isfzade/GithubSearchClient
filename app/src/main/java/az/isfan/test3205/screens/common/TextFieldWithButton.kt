package az.isfan.test3205.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldWithButton(
    imeAction: ImeAction,
    buttonText: String,
    onButtonClick: (searchText: String?) -> Unit,
    defaultFieldValue: String? = null,
) {
    var fieldText by remember {
        mutableStateOf(defaultFieldValue)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 5.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        TextField(
            modifier = Modifier
                .weight(3f),
            value = fieldText ?: "",
            onValueChange = { newText ->
                fieldText = newText
            },
            trailingIcon = if (fieldText != null) {
                {
                    IconButton(
                        onClick = {
                            fieldText = null
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear search bar"
                        )
                    }
                }
            } else null,
            keyboardOptions = KeyboardOptions(
                imeAction = imeAction,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onButtonClick(fieldText)
                },
                onSearch = {
                    onButtonClick(fieldText)
                }
            ),
        )

        Button(
            modifier = Modifier
                .weight(1f),
            onClick = {
                onButtonClick(fieldText)
            }
        ) {
            Text(
                text = buttonText
            )
        }
    }
}