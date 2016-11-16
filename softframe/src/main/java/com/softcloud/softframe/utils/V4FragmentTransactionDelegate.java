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

    private V4FragmentTransactionDelegate(ILifeCycleState.IResume transactionCommitter) {
        pendingTransactions = new ArrayList<>();
        finishedPendingTransactions = new ArrayList<>();
    }

    public static V4FragmentTransactionDelegate create(ILifeCycleState.IResume transactionCommitter) {
        return new V4FragmentTransactionDelegate(transactionCommitter);
    }

    public synchronized void commitOrPend(FragmentTransaction transaction, ILifeCycleState.IResume transactionCommitter) {
        if (transactionCommitter.isResumed()) {
            transaction.commit();
        } else {
            pendingTransactions.add(transaction);
        }
    }

    public synchronized void resumeTransactions(ILifeCycleState.IResume transactionCommitter) {
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
