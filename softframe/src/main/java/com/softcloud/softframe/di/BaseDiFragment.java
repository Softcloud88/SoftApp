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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Component component = getOrInitComponent();
        checkComponent(component);
        presenter = component.presenter();
        injectDependencies(component);
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    private Component getOrInitComponent() {
        Component component;
        if (isComponentFromDiActivity() && getActivity() instanceof HasComponent) {
            component = ((HasComponent<Component>) getActivity()).getComponent();
        } else {
            component = initComponent();
        }
        return component;
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

    /**
     * if activity implement interface HasComponent the component is for the fragment,
     * then set this true.
     * @return
     */
    protected abstract boolean isComponentFromDiActivity();

    /**
     * if component is not from activity, need to init Component here.
     * @return
     */
    protected Component initComponent() {
        return null;
    }

    private void checkComponent(Component component) {
        if (component == null) {
            throw new IllegalStateException("component has not been init! " +
                    "activity should implement interface HasComponent " +
                    "or initComponent return non-null.");
        }
    }
}
