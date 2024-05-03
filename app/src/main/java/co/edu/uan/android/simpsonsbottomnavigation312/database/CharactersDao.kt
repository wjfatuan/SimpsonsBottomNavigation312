package co.edu.uan.android.simpsonsbottomnavigation312.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharactersDao {

    @Insert
    suspend fun create(c: SimpsonCharacter)

    @Query("SELECT * FROM characters")
    suspend fun readAll(): List<SimpsonCharacter>

    @Query("SELECT * FROM characters WHERE name = :pname")
    suspend fun readCharacter(pname: String): SimpsonCharacter
}