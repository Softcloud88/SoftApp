package com.softcloud.softframe.di;

import android.support.annotation.NonNull;

import com.softcloud.softframe.mvp.BasePresenter;
import com.softcloud.softframe.mvp.IView;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public interface BaseComponent<View extends IView, Presenter extends BasePresenter<View>> {
    @NonNull Presenter presenter();
}
