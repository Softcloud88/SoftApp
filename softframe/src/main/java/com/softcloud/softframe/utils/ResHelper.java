package com.softcloud.softframe.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

public class ResHelper {

    private final Context context;

    public ResHelper(Context context) {
        this.context = context;
    }

    public Resources getResources() {
        return context.getResources();
    }

    public int getColor(final @ColorRes int resColor){
        return ContextCompat.getColor(context, resColor);
    }

    public String getString(final @StringRes int resId) {
        return context.getString(resId);
    }

    public Drawable getDrawable(final @DrawableRes int drawableResId) {
        return ContextCompat.getDrawable(context, drawableResId);
    }

}
