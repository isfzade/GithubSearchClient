package az.isfan.test3205.use_cases

import android.util.Log
import az.isfan.test3205.data.db.repos.TokenRepoInterface
import az.isfan.test3205.data.mappers.toData
import az.isfan.test3205.data.models.TokenData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTokenFromDbUseCase @Inject constructor(
    private val repo: TokenRepoInterface
){

    private val TAG = "isf_GetTokenFromDbUseCase"

    suspend fun execute(): TokenData? {
        Log.i(TAG, "execute: ")

        return withContext(Dispatchers.IO) {
            repo.getToken()?.toData()
        }
    }
}