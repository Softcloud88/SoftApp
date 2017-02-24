package com.softcloud.softapp.widgets;

import android.support.annotation.LayoutRes;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2017/2/24.
 */

public interface LoadLayout {

    interface Interactor {
        void onErrorClicked();
    }

    void setOnErrorClickedListener(Interactor interactor);

    void loadingLayoutResId(@LayoutRes int resId);
    void emptyLayoutResId(@LayoutRes int resId);
    void errorLayoutResId(@LayoutRes int resId);

    void showLoading(String msg);
    void showEmpty(String msg);
    void showError(String msg);
    void showContent();

}
