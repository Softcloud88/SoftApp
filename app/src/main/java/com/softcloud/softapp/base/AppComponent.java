package com.softcloud.softapp.base;

import com.softcloud.model.GsonProviderConfigModule;
import com.softcloud.softframe.provider.BaseProviderModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Softcloud on 16/11/24.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        BaseProviderModule.class, ProviderConfigModule.class, GsonProviderConfigModule.class
})
public interface AppComponent {

}
