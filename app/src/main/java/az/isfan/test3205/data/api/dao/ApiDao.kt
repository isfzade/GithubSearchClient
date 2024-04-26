package az.isfan.test3205.data.api.dao

import az.isfan.test3205.data.api.data.SearchApiData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDao {
    @GET("search/repositories")
    suspend fun search(
        @Query("page:") page: Int = 1,
        @Query("per_page:") perPage: Int = 100,
        @Query("q") userName: String,
    ): Response<SearchApiData>
}