package az.isfan.test3205.use_cases

import android.util.Log
import az.isfan.test3205.data.db.entities.TokenEntity
import az.isfan.test3205.data.db.repos.TokenRepoInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertTokenToDbUseCase @Inject constructor(
    private val repo: TokenRepoInterface
){
    private val TAG = "isf_InsertTokenToDbUseCase"

    suspend fun execute(newToken: String?) {
        Log.i(TAG, "execute: ")

        withContext(Dispatchers.IO) {
            repo.insert(
                TokenEntity(
                    token = newToken
                )
            )
        }
    }
}