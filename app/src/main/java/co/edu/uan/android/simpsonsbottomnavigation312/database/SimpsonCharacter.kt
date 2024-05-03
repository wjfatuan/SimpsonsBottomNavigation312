package co.edu.uan.android.simpsonsbottomnavigation312.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class SimpsonCharacter(
    @PrimaryKey val name: String,
    val photo: String,
    val description: String
) {
}