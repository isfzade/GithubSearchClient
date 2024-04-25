package az.isfan.test3205.data.db.repos

import az.isfan.test3205.data.db.entities.TokenEntity

interface TokenRepoInterface {
    suspend fun insert(token: TokenEntity)

    suspend fun getToken(): TokenEntity?
}