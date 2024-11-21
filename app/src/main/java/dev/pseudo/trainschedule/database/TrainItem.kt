package dev.pseudo.trainschedule.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trainItem")
data class TrainItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "nameFrom")
    var nameFrom: String,
    @ColumnInfo(name = "nameWhere")
    var nameWhere: String,
    @ColumnInfo(name = "price")
    var price: Int,
    @ColumnInfo(name = "timeStart")
    var timeStart: String,
    @ColumnInfo(name = "timeFinish")
    var timeFinish: String,
)