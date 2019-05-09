package com.vicky.apps.datapoints.data.remote

import com.vicky.apps.datapoints.data.room.database.AlbumDatabase
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService, private  val albumDatabase: AlbumDatabase) {

    private val albumDao by lazy {
        albumDatabase.albumDao()
    }
    fun getDataFromApi(): Single<List<Any>> = apiService.getDataFromService()

}