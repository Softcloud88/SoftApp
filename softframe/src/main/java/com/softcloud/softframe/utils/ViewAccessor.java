package com.softcloud.softframe.utils;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

public class ViewAccessor {

    public static class ViewAccessorErrorStateException extends IllegalStateException {
        public ViewAccessorErrorStateException(String s) {
            super(s);
        }
    }

    public static final int RES_NULL = -1;

    private final ViewHelper viewHelper;
    private View rootView;

    private ViewAccessor(ViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    public static ViewAccessor create(ViewHelper viewHelper) {
        return new ViewAccessor(viewHelper);
    }

    public ViewAccessor bindRootView(final View rootView) {
        this.rootView = rootView;
        return this;
    }

    private void checkRootView() {
        if (rootView == null) {
            throw new ViewAccessorErrorStateException("ViewAccessor$bindRootView should be called before use!");
        }
    }

    private View getView(@IdRes int tvId) {
        checkRootView();
        View v = rootView.findViewById(tvId);
        if (v != null) {
            return v;
        } else {
            throw new ViewAccessorErrorStateException(String.format("None View found according to id %d", tvId));
        }
    }

    private TextView getTextView(@IdRes int tvId) {
        checkRootView();
        View v = rootView.findViewById(tvId);
        if (v != null && v instanceof TextView) {
            return (TextView) v;
        } else if (v == null) {
            throw new ViewAccessorErrorStateException(String.format("None TextView found according to id %d", tvId));
        } else {
            throw new ViewAccessorErrorStateException(String.format("id %d is not a TextView", tvId));
        }
    }

    private ImageView getImageView(@IdRes int ivId) {
        checkRootView();
        View v = rootView.findViewById(ivId);
        if (v != null && v instanceof ImageView) {
            return (ImageView) v;
        } else if (v == null) {
            throw new ViewAccessorErrorStateException(String.format("None ImageView found according to id %d", ivId));
        } else {
            throw new ViewAccessorErrorStateException(String.format("id %d is not a ImageView", ivId));
        }
    }

    private ViewStub getViewStub(@IdRes int vsId) {
        checkRootView();
        View v = rootView.findViewById(vsId);
        if (v != null && v instanceof ViewStub) {
            return (ViewStub) v;
        } else if (v == null) {
            throw new ViewAccessorErrorStateException(String.format("None ViewStub found according to id %d", vsId));
        } else {
            throw new ViewAccessorErrorStateException(String.format("id %d is not a ViewStub", vsId));
        }
    }

    public ViewAccessor setText(@IdRes int tvId, CharSequence text) {
        viewHelper.setText(getTextView(tvId), text);
        return this;
    }

    public ViewAccessor setText(@IdRes int tvId, CharSequence text, @ColorRes int colorRes) {
        viewHelper.setText(getTextView(tvId), text, colorRes);
        return this;
    }

    public ViewAccessor setTextNumber(@IdRes int tvId, int number) {
        viewHelper.setTextNumber(getTextView(tvId), number);
        return this;
    }

    public ViewAccessor setTextNumber(@IdRes int tvId, float number) {
        viewHelper.setTextNumber(getTextView(tvId), number);
        return this;
    }

    public ViewAccessor setTextNumber(@IdRes int tvId, double number) {
        viewHelper.setTextNumber(getTextView(tvId), number);
        return this;
    }

    public ViewAccessor setTextFromHtml(@IdRes int tvId, String html) {
        viewHelper.setTextFromHtml(getTextView(tvId), html);
        return this;
    }

    public ViewAccessor setTextColor(@IdRes int tvId, @ColorRes int colorResId) {
        viewHelper.setTextColor(getTextView(tvId), colorResId);
        return this;
    }

    public ViewAccessor setTextBold(@IdRes int tvId, boolean isBold) {
        viewHelper.setTextBold(getTextView(tvId), isBold);
        return this;
    }

    public ViewAccessor setTextDrawableRight(@IdRes int tvId, @DrawableRes int drawableResId) {
        viewHelper.setTextDrawableRight(getTextView(tvId), drawableResId);
        return this;
    }

    public ViewAccessor setTextDrawableLeft(@IdRes int tvId, @DrawableRes int drawableResId) {
        viewHelper.setTextDrawableLeft(getTextView(tvId), drawableResId);
        return this;
    }

    public ViewAccessor setBackgroundColor(@IdRes int tvId, @ColorRes int colorId) {
        viewHelper.setBackgroundColor(getView(tvId), colorId);
        return this;
    }

    public ViewAccessor setBackgroundDrawable(@IdRes int tvId, @DrawableRes int resId) {
        viewHelper.setBackgroundDrawable(getView(tvId), resId);
        return this;
    }

    public ViewAccessor setImage(@IdRes int ivId, @DrawableRes int imgResId) {
        viewHelper.setImage(getImageView(ivId), imgResId);
        return this;
    }

    public ViewAccessor setOnClickListener(@IdRes int vId, View.OnClickListener listener) {
        viewHelper.setOnClickListener(getView(vId), listener);
        return this;
    }

    public ViewAccessor setVisibility(@IdRes int vId, @ViewHelper.Visibility int visibility) {
        viewHelper.setVisibility(getView(vId), visibility);
        return this;
    }

    public ViewAccessor inflateViewStub(@IdRes int vsId, @LayoutRes int layoutResId) {
        viewHelper.inflateViewStub(getViewStub(vsId), layoutResId);
        return this;
    }

    public ViewAccessor setEnabled(@IdRes int vId, boolean enabled) {
        viewHelper.setEnabled(getView(vId), enabled);
        return this;
    }

    public ViewAccessor setSelected(@IdRes int vId, boolean selected) {
        viewHelper.setSelected(getView(vId), selected);
        return this;
    }

    public ViewAccessor setOnTouchListener(@IdRes int vId, View.OnTouchListener listener) {
        viewHelper.setOnTouchListener(getView(vId), listener);
        return this;
    }
}
