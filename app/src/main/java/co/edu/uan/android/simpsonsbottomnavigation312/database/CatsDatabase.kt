package co.edu.uan.android.simpsonsbottomnavigation312.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Cat::class), version = 1)
abstract class CatsDatabase: RoomDatabase() {

    abstract fun getCatsDao(): CatsDao

    companion object {

        fun getInstance(context: Context): CatsDatabase {
            val db = Room.databaseBuilder(context, CatsDatabase::class.java, "mycatsdb")
                .build()
            return db
        }
    }
}