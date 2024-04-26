package az.isfan.test3205.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "downloads")
data class DownloadEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val owner: String,
    val repo: String,
    val timestamp: Long,
)