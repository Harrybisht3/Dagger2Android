package com.infy.dagger2kotlin.activity


import android.os.Bundle
import android.widget.Button
import com.infy.dagger2kotlin.R
import com.infy.dagger2kotlin.base.BaseActivity
import com.infy.dagger2kotlin.database.model.LocationData
import com.infy.dagger2kotlin.database.prefrences.MySharedPreferences
import com.infy.dagger2kotlin.database.repository.LocationRepository
import com.infy.dagger2kotlin.networking.ApiInterface
import dagger.android.AndroidInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : BaseActivity() {
    @Inject
    lateinit var apiInterface: ApiInterface
    @Inject
    lateinit var locationRepository: LocationRepository
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences
    lateinit var getTokenButton: Button

    protected override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        savePreferenceData()
        getTokenButton!!.setOnClickListener { getAcessToken() }

    }

    private fun init() {
        getTokenButton = findViewById(R.id.button_gettoken) as Button
    }

    //this is api call to get the acess token
    private fun getAcessToken() {
        val call = apiInterface!!.getLocationInfo(mySharedPreferences!!.getStringData(MySharedPreferences.PREFS_KEY_AUTH)!!,
                mySharedPreferences!!.getStringData(MySharedPreferences.PREFS_KEY_DEVICE_TOKEN)!!, "Android")
        call.enqueue(object : Callback<LocationData> {
            override fun onResponse(call: Call<LocationData>, response: Response<LocationData>) {
                //api success response and save the data in database
                locationRepository!!.insert(response.body())

            }

            override fun onFailure(call: Call<LocationData>, t: Throwable) {
                // Log error here since request failed
            }
        })

    }

    private fun savePreferenceData() {
        mySharedPreferences!!.putData(MySharedPreferences.PREFS_KEY_AUTH, "authorization key here")
        mySharedPreferences!!.putData(MySharedPreferences.PREFS_KEY_DEVICE_TOKEN, "android device token")
    }
}
