package az.isfan.test3205.data.api.repos

import az.isfan.test3205.data.api.data.SearchApiData
import retrofit2.Response

interface ApiRepoInterface {
    suspend fun search(
        page: Int,
        userName: String,
        token: String,
    ): Response<SearchApiData>
}