package az.isfan.test3205.di

import az.isfan.test3205.data.api.repos.ApiRepo
import az.isfan.test3205.data.api.repos.ApiRepoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiRepoModule {
    @Singleton
    @Provides
    fun getRepo(): ApiRepoInterface = ApiRepo()
}