package com.softcloud.softframe.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Softcloud on 16/11/16.
 */

@Module
public class BaseProviderModule {

    @Singleton
    @Provides
    Gson provideGson(final GsonConfig config) {
        final GsonBuilder builder = new GsonBuilder();
        if (config.autoGsonTypeAdapterFactory() != null) {
            builder.registerTypeAdapterFactory(config.autoGsonTypeAdapterFactory());
        }
        return builder
                .setPrettyPrinting()
                .create();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(final OkHttpClientConfig config) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (config.netInterceptors() != null) {
            for (Interceptor netInterceptor : config.netInterceptors()) {
                builder.addNetworkInterceptor(netInterceptor);
            }
        }
        if (config.appInterceptors() != null) {
            for (Interceptor appInterceptor : config.appInterceptors()) {
                builder.addInterceptor(appInterceptor);
            }
        }
        builder.connectTimeout(config.connectionTimeOutSeconds(), TimeUnit.SECONDS)
                .readTimeout(config.readTimeOutSeconds(), TimeUnit.SECONDS)
                .writeTimeout(config.writeTimeOutSeconds(), TimeUnit.SECONDS);
        return builder.build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(final OkHttpClient okHttpClient, final Gson gson, final RetrofitConfig config) {
        return new Retrofit.Builder()
                .baseUrl(config.baseUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }
}
