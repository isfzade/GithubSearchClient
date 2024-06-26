package az.isfan.test3205.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import az.isfan.test3205.data.db.dao.DownloadDao
import az.isfan.test3205.data.db.entities.DownloadEntity

@Database(
    entities = [
        DownloadEntity::class,
    ],
    version=3,
    exportSchema = false)
abstract class Db: RoomDatabase() {

    abstract fun downloadDao(): DownloadDao

    companion object{
        @Volatile
        private var INSTANCE: Db? = null

        fun getDB(context: Context): Db {
            val instance = INSTANCE
            if (instance != null){
                return instance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Db::class.java,
                    "isf_github_client_app_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}