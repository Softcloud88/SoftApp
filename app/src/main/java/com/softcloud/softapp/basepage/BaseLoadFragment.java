package com.softcloud.softapp.basepage;

import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.softcloud.softapp.R;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2017/2/24.
 */

public abstract class BaseLoadFragment<V extends MvpView, P extends MviPresenter<V, ?>> extends BaseFragment<V, P> {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_base_load;
    }

    @Override
    protected void initViews(View rootView) {

    }

    @NonNull
    @Override
    public P createPresenter() {
        return null;
    }
}
