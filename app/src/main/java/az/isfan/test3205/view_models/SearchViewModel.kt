package az.isfan.test3205.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.isfan.test3205.data.models.RepoData
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.use_cases.InsertDownloadToDbUseCase
import az.isfan.test3205.use_cases.SearchByApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchByApiUseCase: SearchByApiUseCase,
    private val insertDownloadToDbUseCase: InsertDownloadToDbUseCase,
): ViewModel() {
    private val TAG = "isf_SearchViewModel"

    private val _repos = MutableStateFlow<Cavab<List<RepoData>>>(Cavab.StandBy)
    val repos = _repos.asStateFlow()

    fun resetRepos() {
        Log.i(TAG, "resetRepos: ")

        _repos.update { Cavab.StandBy }
    }

    fun search(
        userName: String?,
    ) {
        Log.i(TAG, "search: userName=$userName")

        viewModelScope.launch(Dispatchers.Default) {
            try {
                coroutineScope {
                    _repos.update { Cavab.Loading }
                    if (userName == null) throw Exception("Write something to search")
                    val reposFromApi = searchByApiUseCase.execute(
                        userName = userName,
                    )
                    _repos.update {
                        Cavab.Success(reposFromApi)
                    }
                }
            }
            catch (e: Exception) {
                _repos.update {
                    Cavab.Error(e.toString())
                }
            }
        }
    }

    fun saveDownload(
        repo: RepoData
    ) {
        Log.i(TAG, "saveDownload: ")

        CoroutineScope(Dispatchers.Default).launch {
            try {
                coroutineScope {
                    insertDownloadToDbUseCase.execute(repo)
                }
            }
            catch (e: Exception) {
                Log.e(TAG, "saveDownload: e=$e")
            }
        }
    }
}