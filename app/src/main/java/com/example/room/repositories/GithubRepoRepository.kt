package com.example.room.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.room.daos.GithubRepoDAO
import com.example.room.entities.GithubRepo

class GithubRepoRepository(private val repoDAO: GithubRepoDAO){

    fun getAll():LiveData<List<GithubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo:GithubRepo)=repoDAO.insert()

}