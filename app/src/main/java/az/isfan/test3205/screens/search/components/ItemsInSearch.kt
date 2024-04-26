package az.isfan.test3205.screens.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import az.isfan.test3205.R
import az.isfan.test3205.data.models.RepoData
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.screens.common.TextFieldWithButton

@Composable
fun ItemsInSearch(
    repos: Cavab<List<RepoData>>,
    onSearchButtonClick: (searchText: String?) -> Unit,
    onDownloadButtonClick: (repo: RepoData) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top=5.dp, start = 10.dp, end = 10.dp),
    ) {
        item {
            TextFieldWithButton(
                imeAction = ImeAction.Search,
                buttonText = stringResource(R.string.search),
                onButtonClick = onSearchButtonClick,
            )
        }

        if (repos is Cavab.Success) {
            items(count = repos.data.size) { index ->
                ItemInRepo(
                    repo = repos.data[index],
                    onDownloadButtonClick = onDownloadButtonClick,
                )
            }
        }
    }
}