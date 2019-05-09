package com.vicky.apps.datapoints.ui.view
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vicky.apps.datapoints.base.BaseActivity
import com.vicky.apps.datapoints.common.ViewModelProviderFactory
import com.vicky.apps.datapoints.ui.adapter.DataAdapter
import com.vicky.apps.datapoints.ui.viewmodel.MainViewModel
import javax.inject.Inject
import android.util.Log
import com.vicky.apps.datapoints.R
import com.vicky.apps.datapoints.data.room.entity.Albums


class MainActivity : BaseActivity() {



    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModel:MainViewModel

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeValues()
        checkDataInLocal()
        inilializingRecyclerView()

    }

    private fun checkDataInLocal() {
        viewModel.getCount().observe(this, Observer {
            if(it > 0){ fetchDataFromLocal() }
            else{ callApiAndFetchData() }
        })
    }

    private fun fetchDataFromLocal() {
        viewModel.observeDataFromLocal().observe(this, Observer {
            Log.i("count",it.size.toString())
        })
    }

    private fun callApiAndFetchData() {
        viewModel.getApiSubscription().observe(this, Observer {
            if(it!= null && it.isNotEmpty()){
                successCallback(it)
            }else{
                failureCallback()
            }
        })

        viewModel.getDataFromRemote()
    }

    private fun inilializingRecyclerView() {

        recyclerView.layoutManager = GridLayoutManager(this, 3)


        adapter = DataAdapter()

        recyclerView.adapter = adapter
    }

    private fun initializeValues() {

        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.setCompositeData(compositeDisposable)

    }


    private fun successCallback(album: List<Albums>){
      viewModel.insert(album)
    }
    private fun failureCallback(){
        Toast.makeText(this,"API failed",Toast.LENGTH_LONG).show()
    }






}
