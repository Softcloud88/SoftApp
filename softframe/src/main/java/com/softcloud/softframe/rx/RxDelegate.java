package com.softcloud.softframe.rx;

import javax.annotation.concurrent.ThreadSafe;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

@ThreadSafe
public class RxDelegate {

    private CompositeDisposable disposable2Stop;
    private CompositeDisposable disposable2Destroy;

    public synchronized void onCreate() {
        if (disposable2Destroy != null) {
            throw new IllegalStateException("onCreate called multiple times");
        }
        disposable2Destroy = new CompositeDisposable();
    }

    public synchronized void onStart() {
        if (disposable2Stop != null) {
            throw new IllegalStateException("onStart called multiple times");
        }
        disposable2Stop = new CompositeDisposable();
    }

    public synchronized void onStop() {
        if (disposable2Stop == null) {
            throw new IllegalStateException("onStop called multiple times or onStart not called");
        }
        disposable2Stop.dispose();
        disposable2Stop = null;
    }

    public synchronized void onDestroy() {
        if (disposable2Destroy == null) {
            throw new IllegalStateException(
                    "onDestroy called multiple times or onCreate not called");
        }
        disposable2Destroy.dispose();
        disposable2Destroy = null;
    }


    public synchronized boolean addUntilStop(Disposable disposable) {
        if (disposable == null) {
            throw new IllegalStateException(
                    "addUtilStop should be called between onStart and onStop");
        }
        disposable2Stop.add(disposable);
        return true;
    }

    public synchronized boolean addUntilDestroy(Disposable disposable) {
        if (disposable == null) {
            throw new IllegalStateException(
                    "addUtilStop should be called between onCreate and onDestroy");
        }
        disposable2Destroy.add(disposable);
        return true;
    }

    public synchronized void remove(Disposable disposable) {
        if (disposable2Stop == null && disposable2Destroy == null) {
            throw new IllegalStateException("remove should not be called after onDestroy");
        }
        if (disposable2Stop != null) {
            disposable2Stop.remove(disposable);
        }
        if (disposable2Destroy != null) {
            disposable2Destroy.remove(disposable);
        }
    }
}
