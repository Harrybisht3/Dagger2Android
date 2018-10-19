package com.infy.dagger2implementation.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.infy.dagger2implementation.database.model.LocationData;

import java.util.List;

@Dao
public interface LocationDao {
    @Query("SELECT * FROM locationdata")
    List<LocationData> getAll();

    @Query("SELECT * FROM locationdata WHERE latitue=:lat AND longitude=:lng")
    LocationData getByLatLng(String lat, String lng);

    @Insert
    void insertAll(List<LocationData> locationDataList);

    @Insert
    long insert(LocationData locationData);

    @Update
    void update(LocationData locationData);

    @Delete
    int delete(LocationData locationData);
}