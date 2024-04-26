package az.isfan.test3205.di

import az.isfan.test3205.data.db.dao.DownloadDao
import az.isfan.test3205.data.db.dao.TokenDao
import az.isfan.test3205.data.db.repos.DownloadRepo
import az.isfan.test3205.data.db.repos.DownloadRepoInterface
import az.isfan.test3205.data.db.repos.TokenRepo
import az.isfan.test3205.data.db.repos.TokenRepoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbRepoModule {
    @Singleton
    @Provides
    fun provideTokenRepo(dao: TokenDao): TokenRepoInterface = TokenRepo(dao)

    @Singleton
    @Provides
    fun provideDownloadRepo(dao: DownloadDao): DownloadRepoInterface = DownloadRepo(dao)
}