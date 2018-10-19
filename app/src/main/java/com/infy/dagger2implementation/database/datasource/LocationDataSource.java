package com.infy.dagger2implementation.database.datasource;

import com.infy.dagger2implementation.database.dao.LocationDao;
import com.infy.dagger2implementation.database.model.LocationData;
import com.infy.dagger2implementation.database.repository.LocationRepository;

import javax.inject.Inject;

public class LocationDataSource implements LocationRepository {
    private LocationDao locationDao;

    @Inject
    public LocationDataSource(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public long insert(LocationData locationData) {
        return locationDao.insert(locationData);
    }

    @Override
    public int delete(LocationData locationData) {
        return locationDao.delete(locationData);
    }

}
