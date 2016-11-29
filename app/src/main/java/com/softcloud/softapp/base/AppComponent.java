package com.softcloud.softapp.base;

import com.softcloud.model.GsonProviderConfigModule;
import com.softcloud.softframe.provider.BaseProviderModule;
import com.softcloud.softframe.utils.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Softcloud on 16/11/24.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        BaseProviderModule.class, ProviderConfigModule.class, GsonProviderConfigModule.class,
        UtilsModule.class
})
public interface AppComponent {
    Retrofit retrofit();
}
