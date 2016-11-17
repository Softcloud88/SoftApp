package com.softcloud.softframe.provider;

import com.google.auto.value.AutoValue;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/17.
 */

@AutoValue
public abstract class RetrofitConfig {

    public static Builder builder() {
        return new AutoValue_RetrofitConfig.Builder();
    }

    public abstract String baseUrl();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder setBaseUrl(String baseUrl);
        public abstract RetrofitConfig build();
    }

}
