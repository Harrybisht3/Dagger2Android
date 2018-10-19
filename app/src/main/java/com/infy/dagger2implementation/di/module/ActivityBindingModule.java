package com.infy.dagger2implementation.di.module;

import com.infy.dagger2implementation.activity.MainActivity;
import com.infy.dagger2implementation.base.BaseActivity;
import com.infy.dagger2implementation.base.BaseFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = ActivityModule.class)
    abstract BaseActivity baseActivity();

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract BaseFragment provideBaseFragment();
}
