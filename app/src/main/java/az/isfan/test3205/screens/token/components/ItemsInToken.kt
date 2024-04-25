package az.isfan.test3205.screens.token.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import az.isfan.test3205.R
import az.isfan.test3205.general.Constants
import az.isfan.test3205.screens.common.TextFieldWithButton

@Composable
fun ItemsInToken(
    onSaveButtonClick: (tokenText: String?) -> Unit,
) {
    val uriHandler = LocalUriHandler.current

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top=5.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.github_token_needed)
            )
        }

        item {
            TextButton(
                onClick = {
                    try {
                        uriHandler.openUri(Constants.GITHUB_TOKEN_LINK)
                    } catch (e: Exception) {
                        Log.e("isf_", "Github token link: error = $e")
                    }
                }
            ) {
                Text(
                    text = Constants.GITHUB_TOKEN_LINK
                )
            }
        }

        item {
            TextFieldWithButton(
                imeAction = ImeAction.Done,
                buttonText = stringResource(R.string.save),
                onButtonClick = onSaveButtonClick,
            )
        }
    }
}