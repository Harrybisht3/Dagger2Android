package com.infy.dagger2implementation.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.infy.dagger2implementation.activity.MainActivity;
import com.infy.dagger2implementation.base.BaseActivity;
import com.infy.dagger2implementation.base.BaseFragment;
import com.infy.dagger2implementation.di.qualifier.ActivityContext;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class  ActivityModule{
    @Binds
    @ActivityContext
    abstract Activity provideActivity(BaseActivity baseActivity);
    @Binds
    abstract Fragment provideBaseFragment(BaseFragment baseFragment);
    @Binds
    @ActivityContext
    abstract Activity provideMainActivity(MainActivity mainActivity);

}