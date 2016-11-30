package com.softcloud.softframe.utils;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/30.
 */

public class CacheViewAccessor {

    public static class CacheViewAccessorErrorStateException extends IllegalStateException {
        public CacheViewAccessorErrorStateException(String s) {
            super(s);
        }
    }

    private CacheViewAccessor(ViewHelper viewHelper) {
        this.viewHelper = viewHelper;
        cachedViews = new SparseArray<>();
    }

    public static CacheViewAccessor create(ViewHelper viewHelper) {
        return new CacheViewAccessor(viewHelper);
    }

    private ViewHelper viewHelper;
    private View rootView;
    private SparseArray<View> cachedViews;

    public void bindRootView(final View rootView) {
        if (rootView != this.rootView) {
            this.rootView = rootView;
            cachedViews.clear();
        }
    }

    private void checkRootView() {
        if (rootView == null) {
            throw new CacheViewAccessorErrorStateException("CacheViewAccessor$bindRootView should be called before use!");
        }
    }

    private View getView(@IdRes int vId) {
        checkRootView();
        View v = cachedViews.get(vId);
        if (v != null) {
            return v;
        } else {
            v = rootView.findViewById(vId);
            if (v != null) {
                cachedViews.put(vId, v);
                return v;
            } else {
                throw new CacheViewAccessorErrorStateException(String.format("None View found according to id %d", vId));
            }
        }
    }

    private TextView getTextView(@IdRes int tvId) {
        View v = getView(tvId);
        if (v instanceof TextView) {
            return (TextView) v;
        } else {
            throw new CacheViewAccessorErrorStateException(String.format("id %d is not a TextView", tvId));
        }
    }

    private ImageView getImageView(@IdRes int ivId) {
        View v = getView(ivId);
        if (v instanceof ImageView) {
            return (ImageView) v;
        } else {
            throw new CacheViewAccessorErrorStateException(String.format("id %d is not a ImageView", ivId));
        }
    }

    private ViewStub getViewStub(@IdRes int vsId) {
        View v = getView(vsId);
        if (v instanceof ViewStub) {
            return (ViewStub) v;
        } else {
            throw new CacheViewAccessorErrorStateException(String.format("id %d is not a ViewStub", vsId));
        }
    }

    public CacheViewAccessor setText(@IdRes int tvId, CharSequence text) {
        viewHelper.setText(getTextView(tvId), text);
        return this;
    }

    public CacheViewAccessor setText(@IdRes int tvId, CharSequence text, @ColorRes int colorRes) {
        viewHelper.setText(getTextView(tvId), text, colorRes);
        return this;
    }

    public CacheViewAccessor setTextNumber(@IdRes int tvId, int number) {
        viewHelper.setTextNumber(getTextView(tvId), number);
        return this;
    }

    public CacheViewAccessor setTextNumber(@IdRes int tvId, float number) {
        viewHelper.setTextNumber(getTextView(tvId), number);
        return this;
    }

    public CacheViewAccessor setTextNumber(@IdRes int tvId, double number) {
        viewHelper.setTextNumber(getTextView(tvId), number);
        return this;
    }

    public CacheViewAccessor setTextFromHtml(@IdRes int tvId, String html) {
        viewHelper.setTextFromHtml(getTextView(tvId), html);
        return this;
    }

    public CacheViewAccessor setTextColor(@IdRes int tvId, @ColorRes int colorResId) {
        viewHelper.setTextColor(getTextView(tvId), colorResId);
        return this;
    }

    public CacheViewAccessor setTextBold(@IdRes int tvId, boolean isBold) {
        viewHelper.setTextBold(getTextView(tvId), isBold);
        return this;
    }

    public CacheViewAccessor setTextDrawableRight(@IdRes int tvId, @DrawableRes int drawableResId) {
        viewHelper.setTextDrawableRight(getTextView(tvId), drawableResId);
        return this;
    }

    public CacheViewAccessor setTextDrawableLeft(@IdRes int tvId, @DrawableRes int drawableResId) {
        viewHelper.setTextDrawableLeft(getTextView(tvId), drawableResId);
        return this;
    }

    public CacheViewAccessor setBackgroundColor(@IdRes int tvId, @ColorRes int colorId) {
        viewHelper.setBackgroundColor(getView(tvId), colorId);
        return this;
    }

    public CacheViewAccessor setBackgroundDrawable(@IdRes int tvId, @DrawableRes int resId) {
        viewHelper.setBackgroundDrawable(getView(tvId), resId);
        return this;
    }

    public CacheViewAccessor setImage(@IdRes int ivId, @DrawableRes int imgResId) {
        viewHelper.setImage(getImageView(ivId), imgResId);
        return this;
    }

    public CacheViewAccessor setOnClickListener(@IdRes int vId, View.OnClickListener listener) {
        viewHelper.setOnClickListener(getView(vId), listener);
        return this;
    }

    public CacheViewAccessor setVisibility(@IdRes int vId, @ViewHelper.Visibility int visibility) {
        viewHelper.setVisibility(getView(vId), visibility);
        return this;
    }

    public CacheViewAccessor inflateViewStub(@IdRes int vsId, @LayoutRes int layoutResId) {
        viewHelper.inflateViewStub(getViewStub(vsId), layoutResId);
        return this;
    }

    public CacheViewAccessor setEnabled(@IdRes int vId, boolean enabled) {
        viewHelper.setEnabled(getView(vId), enabled);
        return this;
    }

    public CacheViewAccessor setSelected(@IdRes int vId, boolean selected) {
        viewHelper.setSelected(getView(vId), selected);
        return this;
    }

    public CacheViewAccessor setOnTouchListener(@IdRes int vId, View.OnTouchListener listener) {
        viewHelper.setOnTouchListener(getView(vId), listener);
        return this;
    }
}
