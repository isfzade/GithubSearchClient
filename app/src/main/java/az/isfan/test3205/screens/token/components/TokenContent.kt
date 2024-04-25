package az.isfan.test3205.screens.token.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import az.isfan.test3205.R
import az.isfan.test3205.screens.common.TopBarScreen
import az.isfan.test3205.screens.search.components.ItemsInSearch

@Composable
fun TokenContent(
    onSaveButtonClick: (tokenText: String?) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBarScreen(
                title = stringResource(R.string.token),
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
        ) {
            ItemsInToken(
                onSaveButtonClick = onSaveButtonClick,
            )
        }
    }
}