package com.softcloud.softframe.provider;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.moczul.ok2curl.CurlInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
        if (config.logEnable()) {
            builder.addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").d(message))
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(new CurlInterceptor(message -> Timber.tag("Ok2Curl").d(message)));
        }
        return builder.build();
    }
}
