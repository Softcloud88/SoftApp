package com.softcloud.softframe.utils;


import android.support.v4.app.FragmentTransaction;

import com.softcloud.softframe.basepages.ILifeCycleState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/16.
 */

public class V4FragmentTransactionDelegate {

    private final List<FragmentTransaction> pendingTransactions;

    private V4FragmentTransactionDelegate(ILifeCycleState.IResume transactionCommitter) {
        pendingTransactions = new ArrayList<>();
    }

    public static V4FragmentTransactionDelegate create(ILifeCycleState.IResume transactionCommitter) {
        return new V4FragmentTransactionDelegate(transactionCommitter);
    }

    public synchronized void safeCommit(FragmentTransaction transaction, ILifeCycleState.IResume transactionCommitter) {
        if (transactionCommitter.isPageResumed()) {
            transaction.commit();
        } else {
            pendingTransactions.add(transaction);
        }
    }

    public synchronized void onResumed() {
        for (FragmentTransaction transition : pendingTransactions) {
            transition.commit();
        }
        pendingTransactions.clear();
    }
}
