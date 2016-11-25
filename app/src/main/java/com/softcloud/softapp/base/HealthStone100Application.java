package com.softcloud.softapp.base;

import com.softcloud.softframe.SoftApplication;

/**
 * Created by Softcloud on 16/11/24.
 */

public class HealthStone100Application extends SoftApplication {

    private static HealthStone100Application application;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInitializer.getInstance(this).doInit();
        application = this;
        appComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getAppComponent() {
        return application.appComponent;
    }
}
