package com.softcloud.softframe.rx;

import android.support.annotation.CallSuper;

import com.softcloud.softframe.mvp.BasePresenter;
import com.softcloud.softframe.mvp.IView;

import io.reactivex.disposables.Disposable;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public abstract class RxPresenter<View extends IView> extends BasePresenter<View> {

    private final RxDelegate rxDelegate;

    protected RxPresenter() {
        rxDelegate = new RxDelegate();
        rxDelegate.onCreate();
    }

    protected boolean addUntilStop(Disposable disposable) {
        return rxDelegate.addUntilStop(disposable);
    }

    public boolean addUntilDestroy(Disposable disposable) {
        return rxDelegate.addUntilDestroy(disposable);
    }

    public void remove(Disposable disposable) {
        rxDelegate.remove(disposable);
    }

    @CallSuper
    public void attachView(View view) {
        super.attachView(view);
        rxDelegate.onStart();
    }

    @CallSuper
    public void detachView() {
        rxDelegate.onStop();
        super.detachView();
    }

    @CallSuper
    public void onDestroy() {
        rxDelegate.onDestroy();
        super.onDestroy();
    }
}
