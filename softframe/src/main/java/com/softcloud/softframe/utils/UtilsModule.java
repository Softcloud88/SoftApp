package com.softcloud.softframe.utils;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

@Module
public class UtilsModule {

    private final Context context;

    public UtilsModule(final Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    ToastUtils provideToastUtils() {
        return new ToastUtils(context);
    }

    @Singleton
    @Provides
    ScreenUtils provideScreenUtils() {
        return new ScreenUtils(context);
    }

    @Singleton
    @Provides
    ResHelper provideResHelper() {
        return new ResHelper(context);
    }

    @Singleton
    @Provides
    ViewHelper provideViewHelper(ResHelper resHelper) {
        return new ViewHelper(resHelper);
    }
}
