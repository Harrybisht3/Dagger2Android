package com.infy.dagger2kotlin.di.module


import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.infy.dagger2kotlin.App
import com.infy.dagger2kotlin.database.MyDataBase
import com.infy.dagger2kotlin.database.dao.LocationDao
import com.infy.dagger2kotlin.database.datasource.LocationDataSource
import com.infy.dagger2kotlin.database.prefrences.MySharedPreferences
import com.infy.dagger2kotlin.database.repository.LocationRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
     fun provideContext(app: App): Context {
        return app
    }

    // provides the room database object
    @Singleton
    @Provides
     fun providesRoomDatabase(context: Context): MyDataBase {
        return Room.databaseBuilder(context, MyDataBase::class.java, "mydb.db").allowMainThreadQueries().build()
    }

    // provides the Dao object
    @Singleton
    @Provides
     fun providesLocationDao(demoDatabase: MyDataBase): LocationDao {
        return demoDatabase.locationDao()
    }

    //provides the  data repository object
    @Singleton
    @Provides
     fun locationRepository(locationDao: LocationDao): LocationRepository {
        return LocationDataSource(locationDao)
    }


    //provides the SharedPreferences object
    @Singleton
    @Provides
     fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(MySharedPreferences.PREFS_FILE_APP_DATA, Context.MODE_PRIVATE)
    }

}
