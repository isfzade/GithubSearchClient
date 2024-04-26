package az.isfan.test3205.use_cases

import android.util.Log
import az.isfan.test3205.data.db.repos.DownloadRepoInterface
import az.isfan.test3205.data.mappers.toData
import az.isfan.test3205.data.models.DownloadData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetDownloadsFromDbUseCase @Inject constructor(
    private val repo: DownloadRepoInterface
){

    private val TAG = "isf_GetDownloadsFromDbUseCase"

    suspend fun execute(): List<DownloadData> {
        Log.i(TAG, "execute: ")

        return withContext(Dispatchers.IO) {
            repo.getDownloads().map { it.toData() }
        }
    }
}