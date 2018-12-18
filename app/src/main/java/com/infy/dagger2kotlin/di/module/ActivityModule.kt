package com.infy.dagger2kotlin.di.module

import android.app.Activity
import android.support.v4.app.Fragment
import com.infy.dagger2kotlin.activity.MainActivity
import com.infy.dagger2kotlin.base.BaseActivity
import com.infy.dagger2kotlin.base.BaseFragment
import com.infy.dagger2kotlin.di.qualifier.ActivityContext
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityModule {
    @Binds
    @ActivityContext
     abstract fun provideActivity(baseActivity: BaseActivity): Activity

    @Binds
     abstract fun provideBaseFragment(baseFragment: BaseFragment): Fragment

    @Binds
    @ActivityContext
     abstract fun provideMainActivity(mainActivity: MainActivity): Activity

}