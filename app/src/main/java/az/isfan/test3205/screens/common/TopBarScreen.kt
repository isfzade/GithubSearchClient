package az.isfan.test3205.screens.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Token
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun TopBarScreen(
    title: String,
    onBackButtonClick: (() -> Unit)? = null,
    onHistoryButtonClick: (() -> Unit)? = null,
    onTokenButtonClick: (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        navigationIcon =  if (onBackButtonClick != null) {
            {
                IconButton(
                    onClick = onBackButtonClick
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back button"
                    )
                }
            }
        } else null,
        actions = {
            if (onHistoryButtonClick != null) {
                IconButton(
                    onClick = {
                        onHistoryButtonClick()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = "history button of downloaded repos"
                    )
                }
            }

            if (onTokenButtonClick != null) {
                IconButton(
                    onClick = {
                        onTokenButtonClick()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Token,
                        contentDescription = "token button"
                    )
                }
            }
        }
    )
}