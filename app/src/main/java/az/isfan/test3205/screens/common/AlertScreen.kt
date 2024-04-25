package az.isfan.test3205.screens.common

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import az.isfan.test3205.R

@Composable
fun AlertScreen(
    content: String,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        title = {
            Text(
                text = stringResource(R.string.fail),
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis
            )
        },
        text = {
            Text(
                text = content,
                fontSize = 17.sp,
                overflow = TextOverflow.Ellipsis
            )
        },
        onDismissRequest = onDismiss,
        buttons = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(
                    text = stringResource(R.string.ok)
                )
            }
        }
    )
}
