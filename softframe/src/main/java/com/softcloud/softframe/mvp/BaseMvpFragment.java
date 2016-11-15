package com.softcloud.softframe.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public abstract class BaseMvpFragment<View extends IView, Presenter extends BasePresenter<View>>
        extends Fragment implements IView{

    private ViewDelegate<View, Presenter> viewDelegate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDelegate = new ViewDelegate<View, Presenter>() {
            @NonNull
            @Override
            protected Presenter createPresenter() {
                return BaseMvpFragment.this.createPresenter();
            }
        };
        viewDelegate.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onStart() {
        super.onStart();
        viewDelegate.onStart((View) this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewDelegate.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewDelegate.onDestroy();
    }

    protected abstract @NonNull Presenter createPresenter();
}
