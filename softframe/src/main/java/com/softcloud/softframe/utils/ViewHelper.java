package com.softcloud.softframe.utils;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.text.Html;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

public class ViewHelper {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({View.VISIBLE, View.INVISIBLE, View.GONE})
    public  @interface Visibility{}

    private final ResHelper resHelper;
    public static final int RES_NULL = -1;

    public ViewHelper(ResHelper resHelper) {
        this.resHelper = resHelper;
    }

    public void setText(TextView tv, CharSequence text) {
        setText(tv, text, RES_NULL);
    }

    public void setText(TextView tv, CharSequence text, @ColorRes int colorRes) {
        if (tv != null) {
            tv.setText(text);
            if (colorRes != RES_NULL) {
                tv.setTextColor(resHelper.getColor(colorRes));
            }
        }
    }

    public void setTextNumber(TextView tv, int number) {
        String text = SafeCast.getString(number);
        setText(tv, text);
    }

    public void setTextNumber(TextView tv, float number) {
        String text = SafeCast.getString(number);
        setText(tv, text);
    }

    public void setTextNumber(TextView tv, double number) {
        String text = SafeCast.getString(number);
        setText(tv, text);
    }

    public void setTextFromHtml(TextView tv, String formatHtml) {
        if (tv != null) {
            try {
                tv.setText(Html.fromHtml(formatHtml));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTextColor(TextView tv, @ColorRes int colorId) {
        if (tv != null && colorId != RES_NULL) {
            tv.setTextColor(resHelper.getColor(colorId));
        }
    }

    public void setTextBold(TextView tv, boolean isBold) {
        if (tv != null) {
            tv.getPaint().setFakeBoldText(isBold);
        }
    }

    public void setTextDrawableRight(TextView tv, @DrawableRes int drawableResId) {
        if (drawableResId == RES_NULL) {
            return;
        }
        Drawable drawable = resHelper.getDrawable(drawableResId);
        if (tv != null && drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tv.setCompoundDrawables(null, null, drawable, null);
        }
    }

    public void setTextDrawableLeft(TextView tv, @DrawableRes int drawableResId) {
        if (drawableResId == RES_NULL) {
            return;
        }
        Drawable drawable = resHelper.getDrawable(drawableResId);
        if (tv != null && drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tv.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void setBackgroundColor(View view, @ColorRes int colorId) {
        if (view != null) {
            view.setBackgroundColor(resHelper.getColor(colorId));
        }
    }

    public void setBackgroundDrawable(View view, @DrawableRes int resId) {
        if (view != null) {
            view.setBackgroundResource(resId);
        }
    }

    public void setImage(ImageView iv, @DrawableRes int imgResId) {
        if (iv != null && imgResId != 0) {
            iv.setImageDrawable(resHelper.getDrawable(imgResId));
        }
    }

    public void setOnClickListener(View view, View.OnClickListener listener) {
        if (view != null && listener != null) {
            view.setOnClickListener(listener);
        }
    }

    public void setVisibility(View view, @Visibility int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    public void inflateViewStub(ViewStub vs, @LayoutRes int layoutResId) {
        if (vs != null) {
            vs.setLayoutResource(layoutResId);
            vs.inflate();
        }
    }

    public void setEnabled(View view, boolean enabled) {
        if (view != null) {
            view.setEnabled(enabled);
        }
    }

    public void setSelected(View view, boolean selected) {
        if (view != null) {
            view.setSelected(selected);
        }
    }

    public void setOnTouchListener(View view, View.OnTouchListener listener) {
        if (view != null && listener != null) {
            view.setOnTouchListener(listener);
        }
    }
}
