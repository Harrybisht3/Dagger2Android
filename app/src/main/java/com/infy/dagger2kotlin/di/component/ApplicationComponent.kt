package com.infy.dagger2kotlin.di.component

import com.infy.dagger2kotlin.App
import com.infy.dagger2kotlin.di.module.ActivityBindingModule
import com.infy.dagger2kotlin.di.module.AppModule
import com.infy.dagger2kotlin.di.module.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf( AppModule::class,ActivityBindingModule::class, RetrofitModule::class, AndroidSupportInjectionModule::class))
interface ApplicationComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): ApplicationComponent
    }

     override fun inject(app: App)
}
