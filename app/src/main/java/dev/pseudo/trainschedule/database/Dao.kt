package dev.pseudo.trainschedule.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun insertItem(item: TrainItem)

    @Query("SELECT * FROM trainItem")
    fun getAllItem(): List<TrainItem>
}