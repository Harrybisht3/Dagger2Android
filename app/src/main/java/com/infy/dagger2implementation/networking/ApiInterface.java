package com.infy.dagger2implementation.networking;

import com.infy.dagger2implementation.database.model.LocationData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    // a sample of api to get access token
    @FormUrlEncoded
    @POST("/users/accessLocation")
    Call<LocationData> getLocationInfo(@Header("Authorization") String basicCredentials, @Field("device_token") String deviceToken, @Field("device_type") String deviceType);
}
