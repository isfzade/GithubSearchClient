package az.isfan.test3205.data.api.repos

import az.isfan.test3205.data.api.data.SearchApiData
import retrofit2.Response

interface ApiRepoInterface {
    suspend fun search(
        userName: String,
    ): Response<SearchApiData>
}