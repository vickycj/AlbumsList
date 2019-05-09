package com.vicky.apps.datapoints.data.room.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vicky.apps.datapoints.base.AppConstants
import com.vicky.apps.datapoints.data.room.entity.Albums


@Dao
interface AlbumsDao {

    @Query("SELECT * from "+AppConstants.TABLE_NAME+" ORDER BY "+AppConstants.COLUMN_TITLE+" ASC")
    fun getAllAlbums(): LiveData<List<Albums>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(albums: List<Albums>)

    @Query("DELETE FROM "+AppConstants.TABLE_NAME+ "")
    fun deleteAll()
}