package com.example.room.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room.RoomDB
import com.example.room.entities.GithubRepo
import com.example.room.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app){

    private val repository:GithubRepoRepository

    init{
        val repoDao= RoomDB.getInstance(app).repoDAO()
        repository= GithubRepoRepository(repoDao)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

}