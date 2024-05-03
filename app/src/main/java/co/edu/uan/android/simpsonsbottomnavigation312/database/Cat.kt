package co.edu.uan.android.simpsonsbottomnavigation312.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity("cats")
data class Cat(
    @PrimaryKey val uid: String,
    val url: String
) {
}