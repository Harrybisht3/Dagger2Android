package com.infy.dagger2kotlin.database.dao

import android.arch.persistence.room.*
import com.infy.dagger2kotlin.database.model.LocationData

@Dao
interface LocationDao {
    @get:Query("SELECT * FROM locationdata")
    val all: List<LocationData>

    @Query("SELECT * FROM locationdata WHERE latitue=:lat AND longitude=:lng")
    fun getByLatLng(lat: String, lng: String): LocationData

    @Insert
    fun insertAll(locationDataList: List<LocationData>)

    @Insert
    fun insert(locationData: LocationData): Long

    @Update
    fun update(locationData: LocationData)

    @Delete
    fun delete(locationData: LocationData): Int
}