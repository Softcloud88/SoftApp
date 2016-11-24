package com.softcloud.softapp.base;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Softcloud on 16/11/24.
 */

public class AppInitializer {

    private Application application;

    private AppInitializer(Application application) {
        this.application = application;
    }

    public static AppInitializer getInstance(Application application) {
        return new AppInitializer(application);
    }

    public void doInit() {
        Stetho.initializeWithDefaults(application);
    }
}
