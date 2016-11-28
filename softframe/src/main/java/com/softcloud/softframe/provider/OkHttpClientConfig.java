package com.softcloud.softframe.provider;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import okhttp3.Interceptor;

/**
 * Created by Softcloud on 16/11/16.
 */

@AutoValue
public abstract class OkHttpClientConfig {
    public static Builder builder() {
        return new AutoValue_OkHttpClientConfig.Builder()
                .setConnectionTimeOutSeconds(10)
                .setReadTimeOutSeconds(10)
                .setWriteTimeOutSeconds(10);
    }

    public abstract List<Interceptor> netInterceptors();
    public abstract List<Interceptor> appInterceptors();

    public abstract int connectionTimeOutSeconds();
    public abstract int readTimeOutSeconds();
    public abstract int writeTimeOutSeconds();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setNetInterceptors(final List<Interceptor> netInterceptors);
        public abstract Builder setAppInterceptors(final List<Interceptor> appInterceptors);

        public abstract Builder setConnectionTimeOutSeconds(final int connectionTimeOutSeconds);
        public abstract Builder setReadTimeOutSeconds(final int readTimeOutSeconds);
        public abstract Builder setWriteTimeOutSeconds(final int writeTimeOutSeconds);

        public abstract OkHttpClientConfig build();
    }
}
