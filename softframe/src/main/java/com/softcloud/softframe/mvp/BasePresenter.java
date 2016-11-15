package com.softcloud.softframe.mvp;

import android.support.annotation.CallSuper;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public abstract class BasePresenter<View extends IView> implements IPresenter<View>{

    private View view;

    @CallSuper
    public void attachView(View view) {
        this.view = view;
    }

    @CallSuper
    public void detachView() {
        view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @CallSuper
    public void onDestroy() {
        if (isViewAttached()) {
            throw new IllegalStateException("View should been detached before destroy!");
        }
    }

    @Override
    public View getView() {
        if (view == null) {
            throw new IllegalStateException("view has not been attached or has been detached!");
        }
        return view;
    }
}
