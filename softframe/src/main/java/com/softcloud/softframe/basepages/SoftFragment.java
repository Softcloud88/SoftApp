package com.softcloud.softframe.basepages;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softcloud.softframe.di.BaseComponent;
import com.softcloud.softframe.di.BaseDiFragment;
import com.softcloud.softframe.mvp.BasePresenter;
import com.softcloud.softframe.mvp.IView;
import com.softcloud.softframe.utils.V4FragmentTransactionDelegate;
import com.yatatsu.autobundle.AutoBundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/16.
 */

public abstract class SoftFragment<V extends IView, Presenter extends BasePresenter<V>, Component extends BaseComponent<V, Presenter>>
        extends BaseDiFragment<V, Presenter, Component> implements ILifeCycleState.IResume {

    protected View rootView;
    protected LayoutInflater inflater;
    private final V4FragmentTransactionDelegate transactionDelegate = V4FragmentTransactionDelegate.create(this);
    private Unbinder unbinder;

    @CallSuper
    public void onCreate(Bundle savedInstanceState) {
        AutoBundle.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        return inflater.inflate(getLayoutResId(), container, false);
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        initFields();
        if (isUseButterKnife()) {
            bindView(rootView);
        }
        setupView(rootView, savedInstanceState);
        startBusiness();
    }

    @CallSuper
    public void onResume() {
        super.onResume();
        transactionDelegate.onResumed();
    }

    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();
        unBindView();
    }

    protected void safeCommitFragmentTransaction(FragmentTransaction transaction) {
        transactionDelegate.safeCommit(transaction, this);
    }

    private void bindView(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    private void unBindView() {
        if (isUseButterKnife() && unbinder != null) {
            unbinder.unbind();
        }
    }

    protected void initFields(){}

    protected abstract boolean isUseButterKnife();

    protected abstract void setupView(View rootView, Bundle savedInstanceState);

    protected abstract void startBusiness();
}
