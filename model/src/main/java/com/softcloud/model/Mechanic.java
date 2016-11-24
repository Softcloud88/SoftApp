package com.softcloud.model;

import com.google.auto.value.AutoValue;
import com.softcloud.model.base.BaseData;

/**
 * Created by Softcloud on 16/11/24.
 */

@AutoValue
public abstract class Mechanic extends BaseData {

    public abstract String name();
}
