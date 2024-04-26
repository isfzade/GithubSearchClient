package az.isfan.test3205.di

import az.isfan.test3205.data.db.dao.DownloadDao
import az.isfan.test3205.data.db.repos.DownloadRepo
import az.isfan.test3205.data.db.repos.DownloadRepoInterface
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
    fun provideDownloadRepo(dao: DownloadDao): DownloadRepoInterface = DownloadRepo(dao)
}