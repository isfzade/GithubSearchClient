package az.isfan.test3205.screens.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable

@Composable
fun TopBarScreen(
    title: String,
    onBackButtonClick: (() -> Unit)? = null,
    onHistoryButtonClick: (() -> Unit)? = null,
    onSearchButtonClick: (() -> Unit)? = null,
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

            if (onSearchButtonClick != null) {
                IconButton(
                    onClick = {
                        onSearchButtonClick()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search button"
                    )
                }
            }
        }
    )
}