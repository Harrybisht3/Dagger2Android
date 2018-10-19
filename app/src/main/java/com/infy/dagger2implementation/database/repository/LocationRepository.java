package com.infy.dagger2implementation.database.repository;

import com.infy.dagger2implementation.database.model.LocationData;

public interface LocationRepository {
    long insert(LocationData product);

    int delete(LocationData product);

}
