package com.infy.dagger2implementation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.infy.dagger2implementation.R;
import com.infy.dagger2implementation.base.BaseActivity;
import com.infy.dagger2implementation.database.model.LocationData;
import com.infy.dagger2implementation.database.prefrences.MySharedPreferences;
import com.infy.dagger2implementation.database.repository.LocationRepository;
import com.infy.dagger2implementation.networking.ApiInterface;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    @Inject
    ApiInterface apiInterface;
    @Inject
    LocationRepository locationRepository;
    @Inject
    MySharedPreferences mySharedPreferences;
    private Button getTokenButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        savePreferenceData();
        getTokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAcessToken();
            }
        });

    }

    private void init() {
        getTokenButton = (Button) findViewById(R.id.button_gettoken);
    }

    //this is api call to get the acess token
    private void getAcessToken() {
        Call<LocationData> call = apiInterface.getLocationInfo(mySharedPreferences.getStringData(MySharedPreferences.PREFS_KEY_AUTH),
                mySharedPreferences.getStringData(MySharedPreferences.PREFS_KEY_DEVICE_TOKEN), "Android");
        call.enqueue(new Callback<LocationData>() {
            @Override
            public void onResponse(Call<LocationData> call, Response<LocationData> response) {
                //api success response and save the data in database
                locationRepository.insert(response.body());

            }

            @Override
            public void onFailure(Call<LocationData> call, Throwable t) {
                // Log error here since request failed
            }
        });

    }

    private void savePreferenceData() {
        mySharedPreferences.putData(MySharedPreferences.PREFS_KEY_AUTH, "authorization key here");
        mySharedPreferences.putData(MySharedPreferences.PREFS_KEY_DEVICE_TOKEN, "android device token");
    }
}
