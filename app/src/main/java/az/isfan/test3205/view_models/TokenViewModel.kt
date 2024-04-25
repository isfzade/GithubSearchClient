package az.isfan.test3205.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.isfan.test3205.data.models.TokenData
import az.isfan.test3205.general.Cavab
import az.isfan.test3205.use_cases.GetTokenFromDbUseCase
import az.isfan.test3205.use_cases.InsertTokenToDbUseCase
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
class TokenViewModel @Inject constructor(
    private val insertTokenToDbUseCase: InsertTokenToDbUseCase,
    private val getTokenFromDbUseCase: GetTokenFromDbUseCase,
): ViewModel() {
    private val TAG = "isf_TokenViewModel"

    private val _token = MutableStateFlow<Cavab<TokenData>>(Cavab.StandBy)
    val token = _token.asStateFlow()

    private val _firstTimeOpeningApp = MutableStateFlow(false)

    fun resetToken() {
        _token.update {
            Cavab.StandBy
        }
    }

    fun getToken() {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                coroutineScope {
                    _token.update {
                        Cavab.Loading
                    }
                    _token.update {
                        Cavab.Success(
                            getTokenFromDbUseCase.execute() ?: TokenData(null)
                        )
                    }
                }
            }
            catch (e: Exception) {
                Log.e(TAG, "getToken: e=$e")
                _token.update { Cavab.Error(e.toString()) }
            }
        }
    }

    fun saveToken(newToken: String?) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                coroutineScope {
                    insertTokenToDbUseCase.execute(newToken)

                }
            }
            catch (e: Exception) {
                Log.e(TAG, "getToken: e=$e")
            }
        }
    }
}