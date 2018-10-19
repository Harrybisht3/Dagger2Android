package com.infy.dagger2implementation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.infy.dagger2implementation.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger Component intialization
        DaggerAppComponent.builder().application(this)
                .build().inject(this);
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);

    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

}
