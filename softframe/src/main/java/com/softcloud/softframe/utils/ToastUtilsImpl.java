package com.softcloud.softframe.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

public class ToastUtilsImpl implements ToastUtils {

    private final Context context;

    public ToastUtilsImpl(final Context context) {
        this.context = context;
    }

    @Override
    public void show(String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void show(@StringRes int contentResId) {
        Toast.makeText(context, contentResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLong(String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLong(@StringRes int contentResId) {
        Toast.makeText(context, contentResId, Toast.LENGTH_LONG).show();
    }

}
