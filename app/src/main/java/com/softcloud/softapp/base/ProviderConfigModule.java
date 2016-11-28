package com.softcloud.softapp.base;

import android.support.v4.util.ArrayMap;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.softcloud.softapp.BuildConfig;
import com.softcloud.softframe.provider.OkHttpClientConfig;
import com.softcloud.softframe.provider.RetrofitConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created by Softcloud on 16/11/24.
 */

@Module
public class ProviderConfigModule {

    @Singleton
    @Provides
    OkHttpClientConfig provideOkHttpClientConfig(Interceptor headerInterceptor) {
        List<Interceptor> netInterceptors = new ArrayList<>();
        Collections.addAll(netInterceptors, new StethoInterceptor(), headerInterceptor);
        return OkHttpClientConfig.builder()
                .setNetInterceptors(netInterceptors)
                .setAppInterceptors(new ArrayList<>())
                .setConnectionTimeOutSeconds(10)
                .setReadTimeOutSeconds(10)
                .setWriteTimeOutSeconds(10).build();
    }

    @Singleton
    @Provides
    RetrofitConfig provideRetrofitConfig() {
        return RetrofitConfig.builder().setBaseUrl(BuildConfig.API_BASE_URL).build();
    }

    @Singleton
    @Provides
    Interceptor provideHeaderInterceptor(ArrayMap<String, String> headers) {
        return chain -> {
            Request original = chain.request();
            Request.Builder builder = original.newBuilder();
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
            builder.method(original.method(), original.body()).build();
            return chain.proceed(builder.build());
        };
    }

    @Singleton
    @Provides
    ArrayMap<String, String> provideHeaders() {
        ArrayMap<String, String> headers = new ArrayMap<>();
        headers.put("X-Mashape-Key", "CQ844VzifumshUKeLeebUvowAicLp1hh5cGjsnxAW5fLnOiFFi");
        return headers;
    }
}
