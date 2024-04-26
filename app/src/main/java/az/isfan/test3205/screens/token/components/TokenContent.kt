package az.isfan.test3205.screens.token.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import az.isfan.test3205.R
import az.isfan.test3205.data.models.TokenData
import az.isfan.test3205.screens.common.TopBarScreen

@Composable
fun TokenContent(
    token: TokenData,
    onSaveButtonClick: (tokenText: String?) -> Unit,
    onSearchTopBarButtonClick: () -> Unit,
    onHistoryTopBarButtonClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBarScreen(
                title = stringResource(R.string.token),
                onSearchButtonClick = onSearchTopBarButtonClick,
                onHistoryButtonClick = onHistoryTopBarButtonClick,
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
        ) {
            ItemsInToken(
                token = token,
                onSaveButtonClick = onSaveButtonClick,
            )
        }
    }
}