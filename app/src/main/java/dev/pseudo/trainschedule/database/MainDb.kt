package dev.pseudo.trainschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TrainItem::class], version = 2)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): dev.pseudo.trainschedule.database.Dao

    companion object {
        @Volatile
        private var INSTANCE: MainDb? = null

        fun getDb(context: Context): MainDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDb::class.java,
                    "train.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}