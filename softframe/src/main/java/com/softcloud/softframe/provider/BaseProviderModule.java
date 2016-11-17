package com.softcloud.softframe.provider;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.moczul.ok2curl.CurlInterceptor;

import java.util.Collection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Softcloud on 16/11/16.
 */

@Module
public class BaseProviderModule {

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(OkHttpClientConfig config) {
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
        return builder.build();
    }
}
