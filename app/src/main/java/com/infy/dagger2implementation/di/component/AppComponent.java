package com.infy.dagger2implementation.di.component;

import android.app.Application;

import com.infy.dagger2implementation.App;
import com.infy.dagger2implementation.di.module.ActivityBindingModule;
import com.infy.dagger2implementation.di.module.AppModule;
import com.infy.dagger2implementation.di.module.RetrofitModule;
import com.infy.dagger2implementation.di.scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ActivityBindingModule.class, AppModule.class, RetrofitModule.class, AndroidSupportInjectionModule.class})
@ApplicationScope
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

    @Override
    void inject(App app);
}
