package az.isfan.test3205.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import az.isfan.test3205.data.db.entities.TokenEntity

@Dao
interface TokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(token: TokenEntity)

    @Query("SELECT * FROM token WHERE id=0")
    fun getToken(): TokenEntity?
}