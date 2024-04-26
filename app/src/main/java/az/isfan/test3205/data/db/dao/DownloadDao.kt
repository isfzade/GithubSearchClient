package az.isfan.test3205.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import az.isfan.test3205.data.db.entities.DownloadEntity

@Dao
interface DownloadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(download: DownloadEntity)

    @Query("SELECT * FROM downloads ORDER BY timestamp DESC")
    fun getDownloads(): List<DownloadEntity>
}