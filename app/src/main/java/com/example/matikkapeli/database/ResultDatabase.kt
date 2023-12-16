package com.example.matikkapeli.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results_table")
data class ResultDatabase(
    @PrimaryKey(autoGenerate = true)
    var gameId: Long = 0L,

    @ColumnInfo(name = "pisteet")
    val pisteet: Int,

    //@ColumnInfo(name = "start_time_milli")
    //val startTimeMilli: Long = System.currentTimeMillis(),

    //@ColumnInfo(name = "end_time_milli")
    //var endTimeMilli: Long = startTimeMilli,

   // @ColumnInfo(name = "date")
   // val date: Date,

    //@ColumnInfo(name = "time")
    //val time: Int = -1

)
