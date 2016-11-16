package com.softcloud.softframe.provider;

import com.google.auto.value.AutoValue;

/**
 * Created by Softcloud on 16/11/16.
 */

@AutoValue
public abstract class OkHttpClientConfig {
    public static Builder builder() {
        return new AutoValue_OkHttpClientConfig.Builder();
    }

    public abstract boolean logEnable();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setLogEnable(final boolean isLogEnableLog);

        public abstract OkHttpClientConfig build();
    }
}
