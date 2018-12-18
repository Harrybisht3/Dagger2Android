package com.infy.dagger2kotlin.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class LocationData {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
    @ColumnInfo(name = "latitue")
    lateinit var latitue: String
    @ColumnInfo(name = "longitude")
    lateinit var longitude: String
    @ColumnInfo(name = "address")
    lateinit var address: String
}

