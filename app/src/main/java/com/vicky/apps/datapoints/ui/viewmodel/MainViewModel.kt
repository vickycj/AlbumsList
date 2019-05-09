package com.vicky.apps.datapoints.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.vicky.apps.datapoints.common.SchedulerProvider
import com.vicky.apps.datapoints.data.remote.Repository
import com.vicky.apps.datapoints.data.room.entity.Albums
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository,
                    private val schedulerProvider: SchedulerProvider,
                    private val application1: Application): AndroidViewModel(application1) {



    private val apiResponse: MutableLiveData<List<Albums>> = MutableLiveData()

    private val localResponse: MutableLiveData<List<Albums>> = MutableLiveData()

    fun getApiSubscription():MutableLiveData<List<Albums>> = apiResponse

    fun getlocalSubscription():MutableLiveData<List<Albums>> = localResponse

    private lateinit var compositeDisposable: CompositeDisposable




    fun setCompositeData(compositeDisposable: CompositeDisposable) {
        this.compositeDisposable = compositeDisposable
    }



    fun getDataFromRemote() {

        compositeDisposable.add(generateApiCall().subscribeBy ( onSuccess = {
            apiResponse.postValue(it)
        }, onError = {
            Log.d("valuessss",it.message)
            apiResponse.postValue(null)
        } ))


    }
    fun generateApiCall():Single<List<Albums>>{
        return repository.getDataFromApi()
            .compose(schedulerProvider.getSchedulersForSingle())
    }

    fun observeDataFromLocal() : LiveData<List<Albums>> {
        return repository.getDataFromLocal()
    }

    fun insert(albums: List<Albums>) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(albums)
    }




}