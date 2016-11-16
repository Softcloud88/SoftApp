package com.softcloud.softframe.di;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.softcloud.softframe.mvp.BasePresenter;
import com.softcloud.softframe.mvp.IView;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public abstract class BaseMvpDiActivity<View extends IView, Presenter extends BasePresenter<View>, Component extends  BaseComponent<View, Presenter>>
        extends AppCompatActivity implements HasComponent<Component>{

    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        initializeDi();
        super.onCreate(savedInstanceState);
    }

    /**
     * normally, init component here, and let interface method getComponent return the result.
     */
    protected abstract void initializeDi();
}
