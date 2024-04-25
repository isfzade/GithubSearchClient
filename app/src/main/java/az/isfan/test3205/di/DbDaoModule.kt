package az.isfan.test3205.di

import android.content.Context
import az.isfan.test3205.data.db.Db
import az.isfan.test3205.data.db.dao.TokenDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbDaoModule {
    @Singleton
    @Provides
    fun provideTokenDao(@ApplicationContext context: Context): TokenDao = Db.getDB(context).tokenDao()
}