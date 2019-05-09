package com.vicky.apps.datapoints.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vicky.apps.datapoints.base.AppConstants


@Entity(tableName = AppConstants.TABLE_NAME)
data class Albums(@ColumnInfo(name = "user") val user: Int,
                  @PrimaryKey @ColumnInfo(name = "id") val id: Int,
                  @ColumnInfo(name = "title")val title: String) {
}