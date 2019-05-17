package com.example.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.room.entities.GithubRepo

@Dao
interface GithubRepoDAO {

    @Query("SELECT*FROM repos")
    fun getAll():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert()

    @Query("DELETE FROM repos")
    fun nukeTable()

}