package co.edu.uan.android.simpsonsbottomnavigation312.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(SimpsonCharacter::class), version = 1)
abstract class SimpsonsDatabase: RoomDatabase() {

    abstract fun characterDao(): CharactersDao

    companion object {
         fun getInstance(context: Context): SimpsonsDatabase {
             val db = Room.databaseBuilder(context, SimpsonsDatabase::class.java, "simpsonsdb")
                 .build()
             return db
         }
    }
}