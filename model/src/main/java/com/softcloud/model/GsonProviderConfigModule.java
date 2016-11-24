package com.softcloud.model;

import com.softcloud.model.base.AutoValueGsonAdapterFactory;
import com.softcloud.softframe.provider.GsonConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Softcloud on 16/11/24.
 */

@Module
public class GsonProviderConfigModule {

    @Singleton
    @Provides
    GsonConfig provideGsonConfig() {
        return GsonConfig.builder()
                .autoGsonTypeAdapterFactory(AutoValueGsonAdapterFactory.create())
                .build();
    }

}
