package com.example.matikkapeli.database
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ResultDatabaseDao {


        @Insert
        suspend fun insert(result: ResultDatabase)

        @Update
        suspend fun update(result: ResultDatabase)

        @Query("SELECT * from results_database WHERE id = :key")
        suspend fun get(key: Long): ResultDatabase?

        @Query("DELETE FROM results_table")
        suspend fun clear()

        @Query("SELECT * FROM results_table ORDER BY id DESC")
        fun getAllGames(): LiveData<List<ResultDatabase>>

        @Query("SELECT * FROM results_table ORDER BY id DESC LIMIT 1")
        suspend fun getthisgame(): ResultDatabase


    }





