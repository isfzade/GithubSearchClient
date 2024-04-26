package az.isfan.test3205.di

import az.isfan.test3205.data.api.repos.ApiRepoInterface
import az.isfan.test3205.data.db.repos.DownloadRepoInterface
import az.isfan.test3205.use_cases.GetDownloadsFromDbUseCase
import az.isfan.test3205.use_cases.InsertDownloadToDbUseCase
import az.isfan.test3205.use_cases.SearchByApiUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetDownloadsFromDbUseCase(
        repo: DownloadRepoInterface
    ) = GetDownloadsFromDbUseCase(repo)

    @Singleton
    @Provides
    fun provideInsertDownloadToDbUseCase(
        repo: DownloadRepoInterface
    ) = InsertDownloadToDbUseCase(repo)

    @Singleton
    @Provides
    fun provideSearchByApiUseCase(
        apiRepo: ApiRepoInterface
    ) = SearchByApiUseCase(apiRepo)
}