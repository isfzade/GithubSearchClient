package az.isfan.test3205.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token")
data class TokenEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Long = 0,

    var token: String? = null
)