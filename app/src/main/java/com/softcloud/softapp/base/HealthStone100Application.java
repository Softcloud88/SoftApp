package com.softcloud.softapp.base;

import com.softcloud.softframe.SoftApplication;

/**
 * Created by Softcloud on 16/11/24.
 */

public class HealthStone100Application extends SoftApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppInitializer.getInstance(this).doInit();
    }
}
