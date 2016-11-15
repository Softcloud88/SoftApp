package com.softcloud.softframe.mvp;

import android.os.Bundle;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public interface IViewDelegate<View extends IView> {
    void onCreate(Bundle savedInstanceState);
    void onStart(View view);
    void onStop();
    void onDestroy();
}
