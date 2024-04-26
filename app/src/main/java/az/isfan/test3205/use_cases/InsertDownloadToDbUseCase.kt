package az.isfan.test3205.use_cases

import android.util.Log
import az.isfan.test3205.data.db.repos.DownloadRepoInterface
import az.isfan.test3205.data.mappers.toEntity
import az.isfan.test3205.data.models.RepoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertDownloadToDbUseCase @Inject constructor(
    private val repo: DownloadRepoInterface
){
    private val TAG = "isf_InsertDownloadToDbUseCase"

    suspend fun execute(download: RepoData) {
        Log.i(TAG, "execute: ")

        withContext(Dispatchers.IO) {
            repo.insert(
                download.toEntity()
            )
        }
    }
}