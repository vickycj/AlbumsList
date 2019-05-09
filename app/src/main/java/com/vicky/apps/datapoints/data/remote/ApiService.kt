package com.vicky.apps.datapoints.data.remote


import com.vicky.apps.datapoints.data.room.entity.Albums
import io.reactivex.Single
import retrofit2.http.GET


interface ApiService {
    @GET("")
    fun getDataFromService(): Single<List<Albums>>
}
