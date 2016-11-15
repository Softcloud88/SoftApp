package com.softcloud.softframe.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public abstract class ViewDelegate<View extends IView, Presenter extends BasePresenter<View>> implements IViewDelegate<View> {

    private Presenter presenter;

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        presenter = createPresenter();
        checkPresenter();
    }

    @Override
    public void onStart(View view) {
        checkPresenter();
        presenter.attachView(view);
    }

    @Override
    public void onStop() {
        checkPresenter();
        presenter.detachView();
    }

    @Override
    public void onDestroy() {
        checkPresenter();
        presenter.onDestroy();
    }

    protected abstract @NonNull Presenter createPresenter();

    private void checkPresenter() {
        if (presenter == null) {
            throw new IllegalStateException(
                    "presenter must be non-null, check if ViewDelegate#onCreate is called!");
        }
    }
}
