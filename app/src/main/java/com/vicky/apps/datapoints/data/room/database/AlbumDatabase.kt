package com.vicky.apps.datapoints.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vicky.apps.datapoints.data.room.dao.AlbumsDao
import com.vicky.apps.datapoints.data.room.entity.Albums

@Database(entities = arrayOf(Albums::class), version = 1)
public abstract class   AlbumDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumsDao

}