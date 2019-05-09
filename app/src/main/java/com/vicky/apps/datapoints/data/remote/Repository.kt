package com.vicky.apps.datapoints.data.remote

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.vicky.apps.datapoints.data.room.database.AlbumDatabase
import com.vicky.apps.datapoints.data.room.entity.Albums
import io.reactivex.Observable
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService, private  val albumDatabase: AlbumDatabase) {

    private val albumDao by lazy {
        albumDatabase.albumDao()
    }
    fun getDataFromApi(): Single<List<Albums>> = apiService.getDataFromService()

    fun getDataFromLocal(): LiveData<List<Albums>> = albumDao.getAllAlbums()

    @WorkerThread
    suspend fun insert(word: List<Albums>) {
        albumDao.insert(word)
    }

}