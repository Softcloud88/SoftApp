package com.softcloud.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.softcloud.model.base.BaseData;

/**
 * Created by Softcloud on 16/11/24.
 */

@AutoValue
public abstract class Mechanic extends BaseData {

    public abstract String name();

    public static TypeAdapter<Mechanic> typeAdapter(final Gson gson) {
        return new AutoValue_Mechanic.GsonTypeAdapter(gson);
    }
}
