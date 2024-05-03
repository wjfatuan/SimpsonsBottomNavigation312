package co.edu.uan.android.simpsonsbottomnavigation312.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CatsDao {

    @Insert
    suspend fun create(c: Cat)

    @Query("SELECT * FROM cats")
    suspend fun readAll(): List<Cat>

    @Query("SELECT * FROM cats WHERE uid = :id")
    suspend fun readById(id: String): Cat

    @Update
    suspend fun update(c: Cat)

    @Delete
    suspend fun delete(c: Cat)
}