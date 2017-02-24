package com.softcloud.softapp.basepage;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvi.MviFragment;
import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.softcloud.softframe.basepages.ILifeCycleState;
import com.softcloud.softframe.utils.V4FragmentTransactionDelegate;
import com.yatatsu.autobundle.AutoBundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2017/2/24.
 */

public abstract class BaseFragment<V extends MvpView, P extends MviPresenter<V, ?>> extends MviFragment<V, P>
        implements ILifeCycleState.IResume {

    private final V4FragmentTransactionDelegate transactionDelegate = V4FragmentTransactionDelegate.create(this);

    protected View rootView;
    private Unbinder unbinder;

    @CallSuper
    public void onCreate(Bundle savedInstanceState) {
        AutoBundle.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    protected abstract @LayoutRes int getLayoutResId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        unbinder = ButterKnife.bind(this, rootView);
        initViews(rootView);
    }

    protected abstract void initViews(View rootView);

    @CallSuper
    public void onResume() {
        super.onResume();
        transactionDelegate.onResumed();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected void safeCommitFragmentTransaction(FragmentTransaction transaction) {
        transactionDelegate.safeCommit(transaction, this);
    }

    @Override
    public boolean isPageResumed() {
        return isResumed();
    }
}
