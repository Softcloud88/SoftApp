package com.softcloud.softframe.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

public class ScreenUtils {

    private final Context context;

    public ScreenUtils(@NonNull final Context context) {
        this.context = context;
    }

    public int dip2px(final int dipValue) {
        final float reSize = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * reSize + 0.5);
    }

    public int px2dip(final int pxValue) {
        final float reSize = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / reSize + 0.5);
    }

    public int getScreenHeight(@NonNull final Activity activity) {
        final Display display = activity.getWindowManager().getDefaultDisplay();
        final DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return metrics.heightPixels;
    }

    public int getScreenWidth(@NonNull final Activity activity) {
        final Display display = activity.getWindowManager().getDefaultDisplay();
        final DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return metrics.widthPixels;
    }
}
