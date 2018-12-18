package com.infy.dagger2kotlin.networking

import com.infy.dagger2kotlin.database.model.LocationData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    // a sample of api to get access token
    @FormUrlEncoded
    @POST("/users/accessLocation")
    fun getLocationInfo(@Header("Authorization") basicCredentials: String, @Field("device_token") deviceToken: String, @Field("device_type") deviceType: String): Call<LocationData>
}
