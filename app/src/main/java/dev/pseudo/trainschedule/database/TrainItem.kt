package dev.pseudo.trainschedule.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trainItem")
data class TrainItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val from: String,
    val to: String,
    val departureTime: String,
    val duration: String,
    val arrivalTime: String,
    val station: String,
    val prices: String
)