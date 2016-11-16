package com.softcloud.softframe.basepages;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.softcloud.softframe.di.BaseComponent;
import com.softcloud.softframe.di.BaseMvpDiActivity;
import com.softcloud.softframe.mvp.BasePresenter;
import com.softcloud.softframe.mvp.IView;
import com.softcloud.softframe.utils.V4FragmentTransactionDelegate;
import com.yatatsu.autobundle.AutoBundle;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/16.
 */

public abstract class SoftActivity<View extends IView, Presenter extends BasePresenter<View>, Component extends BaseComponent<View, Presenter>>
        extends BaseMvpDiActivity<View, Presenter, Component> implements ILifeCycleState.IResume {

    private final V4FragmentTransactionDelegate transactionDelegate = V4FragmentTransactionDelegate.create(this);
    private volatile boolean isResumed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            AutoBundle.bind(this);
        } else {
            AutoBundle.bind(this, savedInstanceState);
        }
        super.onCreate(savedInstanceState);
        isResumed = true;
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        isResumed = true;
        transactionDelegate.onResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isResumed = false;
    }

    @Override
    public boolean isResumed() {
        return isResumed;
    }

    protected void safeCommitFragmentTransaction(FragmentTransaction transaction) {
        transactionDelegate.safeCommit(transaction, this);
    }

}
