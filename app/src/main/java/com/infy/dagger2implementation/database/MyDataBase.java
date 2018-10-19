package com.infy.dagger2implementation.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.infy.dagger2implementation.database.dao.LocationDao;
import com.infy.dagger2implementation.database.model.LocationData;

@Database(entities = {LocationData.class}, version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    public abstract LocationDao locationDao();

}
