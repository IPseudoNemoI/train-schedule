package dev.pseudo.trainschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TrainItem::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): dev.pseudo.trainschedule.database.Dao

    companion object {
        fun getDb(contex: Context): MainDb {
            return Room.databaseBuilder(
                contex.applicationContext,
                MainDb::class.java,
                "train.db"
            ).build()
        }
    }
}