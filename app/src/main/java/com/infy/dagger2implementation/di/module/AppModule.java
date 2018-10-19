package com.infy.dagger2implementation.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.infy.dagger2implementation.database.MyDataBase;
import com.infy.dagger2implementation.database.dao.LocationDao;
import com.infy.dagger2implementation.database.datasource.LocationDataSource;
import com.infy.dagger2implementation.database.prefrences.MySharedPreferences;
import com.infy.dagger2implementation.database.repository.LocationRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class AppModule {
    @Singleton
    @Provides
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }
    // provides the room database object
    @Singleton
    @Provides
    MyDataBase providesRoomDatabase(Context context) {
        return Room.databaseBuilder(context, MyDataBase.class, "mydb.db").allowMainThreadQueries().build();
    }
    // provides the Dao object
    @Singleton
    @Provides
    LocationDao providesLocationDao(MyDataBase demoDatabase) {
        return demoDatabase.locationDao();
    }
    //provides the  data repository object
    @Singleton
    @Provides
    LocationRepository locationRepository(LocationDao locationDao) {
        return new LocationDataSource(locationDao);
    }


    //provides the SharedPreferences object
    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(MySharedPreferences.PREFS_FILE_APP_DATA, Context.MODE_PRIVATE);
    }

}
