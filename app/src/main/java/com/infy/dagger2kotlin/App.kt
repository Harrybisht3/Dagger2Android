package com.infy.dagger2kotlin

import android.app.Activity
import android.app.Application
import com.infy.dagger2kotlin.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        //Dagger Component intialization
        DaggerApplicationComponent.builder().application(this)
                .build().inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

}
