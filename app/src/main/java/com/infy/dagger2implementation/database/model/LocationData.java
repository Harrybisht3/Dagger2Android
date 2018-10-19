package com.infy.dagger2implementation.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class LocationData {

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "latitue")
    String latitue;
    @ColumnInfo(name = "longitude")
    String longitude;
    @ColumnInfo(name = "address")
    String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitue() {
        return latitue;
    }

    public void setLatitue(String latitue) {
        this.latitue = latitue;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

