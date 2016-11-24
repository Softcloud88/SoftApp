package com.softcloud.softframe.provider;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapterFactory;

/**
 * Created by Softcloud on 16/11/24.
 */

@AutoValue
public abstract class GsonConfig {
    public static Builder builder() {
        return new AutoValue_GsonConfig.Builder();
    }

    @Nullable
    public abstract TypeAdapterFactory autoGsonTypeAdapterFactory();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder autoGsonTypeAdapterFactory(
                @Nullable final TypeAdapterFactory typeAdapterFactory);

        public abstract GsonConfig build();
    }
}
