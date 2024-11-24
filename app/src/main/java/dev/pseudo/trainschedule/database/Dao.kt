package dev.pseudo.trainschedule.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("DELETE FROM trainItem")
    suspend fun clearAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrains(trains: List<TrainItem>)

    @Query("SELECT * FROM trainItem")
    fun getAllTrains(): LiveData<List<TrainItem>>
}