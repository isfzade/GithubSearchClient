package az.isfan.test3205.data.api.repos

import android.util.Log
import az.isfan.test3205.data.api.RetroSettings
import az.isfan.test3205.data.api.data.SearchApiData
import retrofit2.Response

class ApiRepo: ApiRepoInterface {
    private val TAG = "isf_ApiRepo"

    override suspend fun search(
        userName: String,
    ): Response<SearchApiData> {
        Log.i(TAG, "search: ")
        return RetroSettings.api.search(
            userName = "user:$userName",
        )
    }
}