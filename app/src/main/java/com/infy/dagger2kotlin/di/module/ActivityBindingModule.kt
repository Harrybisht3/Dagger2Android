package com.infy.dagger2kotlin.di.module

import com.infy.dagger2kotlin.activity.MainActivity
import com.infy.dagger2kotlin.base.BaseActivity
import com.infy.dagger2kotlin.base.BaseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class))
     abstract fun baseActivity(): BaseActivity

    @ContributesAndroidInjector
     abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
     abstract fun provideBaseFragment(): BaseFragment
}
