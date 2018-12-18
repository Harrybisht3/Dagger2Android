package com.infy.dagger2kotlin.database.datasource

import com.infy.dagger2kotlin.database.dao.LocationDao
import com.infy.dagger2kotlin.database.model.LocationData
import com.infy.dagger2kotlin.database.repository.LocationRepository

import javax.inject.Inject

class LocationDataSource @Inject
constructor(private val locationDao: LocationDao) : LocationRepository {

    override fun insert(locationData: LocationData): Long {
        return locationDao.insert(locationData)
    }

    override fun delete(locationData: LocationData): Int {
        return locationDao.delete(locationData)
    }

}
