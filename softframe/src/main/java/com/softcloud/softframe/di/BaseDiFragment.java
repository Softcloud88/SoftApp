package com.softcloud.softframe.di;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.softcloud.softframe.mvp.BaseMvpFragment;
import com.softcloud.softframe.mvp.BasePresenter;
import com.softcloud.softframe.mvp.IView;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public abstract class BaseDiFragment<View extends IView, Presenter extends BasePresenter<View>, Component extends BaseComponent<View, Presenter>>
        extends BaseMvpFragment<View, Presenter> {

    protected Presenter presenter;

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Component component = ((HasComponent<Component>) getActivity()).getComponent();
        presenter = component.presenter();
        injectDependencies(component);
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    protected Presenter createPresenter() {
        return presenter;
    }

    /**
     * inject dependencies.
     * Normally implementation should be {@code component.inject(this)}
     */
    protected abstract void injectDependencies(Component component);
}
