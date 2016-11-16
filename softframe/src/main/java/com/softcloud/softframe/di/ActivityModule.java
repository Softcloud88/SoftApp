package com.softcloud.softframe.di;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/16.
 */

@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }
}
