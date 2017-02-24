package com.softcloud.softapp.widgets;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2017/2/24.
 */

public class DefaultLoadLayoutImpl extends FrameLayout implements LoadLayout {

    public DefaultLoadLayoutImpl(Context context) {
        this(context, null);
    }

    public DefaultLoadLayoutImpl(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DefaultLoadLayoutImpl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnErrorClickedListener(Interactor interactor) {

    }

    @Override
    public void loadingLayoutResId(@LayoutRes int resId) {

    }

    @Override
    public void emptyLayoutResId(@LayoutRes int resId) {

    }

    @Override
    public void errorLayoutResId(@LayoutRes int resId) {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void showEmpty(String msg) {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent() {

    }
}
