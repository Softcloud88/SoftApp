package com.softcloud.softapp.base;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.softcloud.softapp.BuildConfig;
import com.softcloud.softframe.provider.OkHttpClientConfig;
import com.softcloud.softframe.provider.RetrofitConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;

/**
 * Created by Softcloud on 16/11/24.
 */

@Module
public class ProviderConfigModule {

    @Singleton
    @Provides
    OkHttpClientConfig provideOkHttpClientConfig() {
        List<Interceptor> netInterceptors = new ArrayList<>();
        Collections.addAll(netInterceptors, new StethoInterceptor());
        return OkHttpClientConfig.builder().setAppInterceptors(new ArrayList<>())
                .setNetInterceptors(netInterceptors)
                .setConnectionTimeOutSeconds(10)
                .setReadTimeOutSeconds(10)
                .setWriteTimeOutSeconds(10).build();
    }

    @Singleton
    @Provides
    RetrofitConfig provideRetrofitConfig() {
        return RetrofitConfig.builder().setBaseUrl(BuildConfig.API_BASE_URL).build();
    }
}
