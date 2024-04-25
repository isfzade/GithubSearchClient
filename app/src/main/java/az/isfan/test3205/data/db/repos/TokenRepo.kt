package az.isfan.test3205.data.db.repos

import az.isfan.test3205.data.db.dao.TokenDao
import az.isfan.test3205.data.db.entities.TokenEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenRepo @Inject constructor(private val dao: TokenDao): TokenRepoInterface {
    override suspend fun insert(token: TokenEntity) {
        dao.insert(token)
    }

    override suspend fun getToken(): TokenEntity? {
        return dao.getToken()
    }
}