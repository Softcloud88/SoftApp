package com.softcloud.softframe.utils;

import android.support.annotation.StringRes;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

public interface ToastUtils {
    void show(final String content);

    void show(@StringRes final int contentResId);

    void showLong(final String content);

    void showLong(@StringRes final int contentResId);
}
