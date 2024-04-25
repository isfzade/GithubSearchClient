package az.isfan.test3205.use_cases

import android.util.Log
import az.isfan.test3205.data.api.data.SearchApiData
import az.isfan.test3205.data.api.repos.ApiRepoInterface
import az.isfan.test3205.data.mappers.toData
import az.isfan.test3205.data.models.RepoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class SearchByApiUseCase @Inject constructor(
    private val apiRepo: ApiRepoInterface,
) {
    private val TAG = "isf_SearchByApiUseCase"

    suspend fun execute(
        page: Int,
        userName: String,
        token: String,
    ): List<RepoData> {
        Log.i(TAG, "execute: ")

        return withContext(Dispatchers.IO) {
            getBody(
                apiRepo.search(
                    page = page,
                    userName = userName,
                    token = token
                )
            )
        }.toData()
    }

    private fun getBody(response: Response<SearchApiData>): SearchApiData {
        Log.i(TAG, "getBody: ")

        if (response.isSuccessful) {
            return response.body()!!
        }
        else {
            throw Exception("Response is not successful. code = ${response.code()}, " +
                    "errorBody = ${response.errorBody()?.string()}")
        }
    }
}