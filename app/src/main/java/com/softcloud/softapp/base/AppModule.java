package com.softcloud.softapp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.softcloud.model.base.AllCardsModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Softcloud on 16/11/24.
 */

@Module
public class AppModule {
    private final Application application;

    public AppModule(final Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application privideApplication() {
        return application;
    }

    @Singleton
    @Provides
    Resources provideResources(Application application) {
        return application.getResources();
    }

    @Singleton
    @Provides
    Context provideContext(Application application) {
        return application;
    }
}
