package com.infy.dagger2kotlin.database.repository;

import com.infy.dagger2kotlin.database.model.LocationData;

public interface LocationRepository {
    long insert(LocationData product);

    int delete(LocationData product);

}
