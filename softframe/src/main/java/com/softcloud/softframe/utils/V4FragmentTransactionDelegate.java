package com.softcloud.softframe.utils;


import android.support.v4.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/16.
 */

public class V4FragmentTransactionDelegate {

    private final List<FragmentTransaction> pendingTransactions;
    private final List<FragmentTransaction> finishedPendingTransactions;
    private final ILifeCycleState.IResume transactionCommitter;

    private V4FragmentTransactionDelegate(ILifeCycleState.IResume transactionCommitter) {
        pendingTransactions = new ArrayList<>();
        finishedPendingTransactions = new ArrayList<>();
        this.transactionCommitter = transactionCommitter;
    }

    public static V4FragmentTransactionDelegate create(ILifeCycleState.IResume transactionCommitter) {
        return new V4FragmentTransactionDelegate(transactionCommitter);
    }

    public synchronized void commitOrPend(FragmentTransaction transaction) {
        if (transactionCommitter.isResumed()) {
            transaction.commit();
        } else {
            pendingTransactions.add(transaction);
        }
    }

    public synchronized void resumeTransactions() {
        for (FragmentTransaction transition : pendingTransactions) {
            if (transactionCommitter.isResumed()) {
                transition.commit();
                finishedPendingTransactions.add(transition);
            } else {
                break;
            }
        }
        pendingTransactions.removeAll(finishedPendingTransactions);
        finishedPendingTransactions.clear();
    }
}
