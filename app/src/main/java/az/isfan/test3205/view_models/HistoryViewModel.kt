package az.isfan.test3205.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.isfan.test3205.data.models.DownloadData
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.use_cases.GetDownloadsFromDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getDownloadsFromDbUseCase: GetDownloadsFromDbUseCase,
): ViewModel() {
    private val TAG = "isf_HistoryViewModel"

    private val _downloads = MutableStateFlow<Cavab<List<DownloadData>>>(Cavab.StandBy)
    val downloads = _downloads.asStateFlow()

    init {
        getDownloads()
    }

    fun resetDownloads() {
        Log.i(TAG, "resetDownloads: ")

        _downloads.update { Cavab.StandBy }
    }

    private fun getDownloads() {
        Log.i(TAG, "getDownloads: ")

        viewModelScope.launch(Dispatchers.Default) {
            try {
                _downloads.update { Cavab.Loading }
                val dbDownloads = getDownloadsFromDbUseCase.execute()
                _downloads.update {
                    Cavab.Success(dbDownloads)
                }
            }
            catch (e: Exception) {
                Log.e(TAG, "getDownloads: e=$e")
                _downloads.update {
                    Cavab.Error(e.toString())
                }
            }
        }
    }
}