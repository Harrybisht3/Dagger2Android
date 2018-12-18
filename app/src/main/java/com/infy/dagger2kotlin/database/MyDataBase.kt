package com.infy.dagger2kotlin.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.infy.dagger2kotlin.database.dao.LocationDao
import com.infy.dagger2kotlin.database.model.LocationData

@Database(entities = arrayOf(LocationData::class), version = 1, exportSchema = false)
abstract class MyDataBase : RoomDatabase() {
    abstract fun locationDao(): LocationDao

}
