package com.softcloud.softframe.mvp;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public interface IPresenter<View extends IView> {
    void attachView(View view);
    void detachView();
    void onDestroy();
    boolean isViewAttached();
    View getView();
}
