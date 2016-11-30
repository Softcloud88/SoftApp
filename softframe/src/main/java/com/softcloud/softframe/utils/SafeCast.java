package com.softcloud.softframe.utils;

import timber.log.Timber;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/29.
 */

public class SafeCast {

    public static String getString(int value) {
        return String.valueOf(value);
    }

    public static String getString(double value) {
        return String.valueOf(value);
    }

    public static String getString(float value) {
        return String.valueOf(value);
    }

    public static int getInt(String value) {
        int res = 0;
        try {
            res = Integer.valueOf(value);
        } catch (Exception e) {
            Timber.e(e);
        }
        return res;
    }

    public static int getInt(String value, int defVal) {
        int res = defVal;
        try {
            res = Integer.valueOf(value);
        } catch (Exception e) {
            Timber.e(e);
        }
        return res;
    }

    public static double getDouble(String value) {
        double res = 0;
        try {
            res = Double.valueOf(value);
        } catch (Exception e) {
            Timber.e(e);
        }
        return res;
    }

    public static float getFloat(String value) {
        float res = 0;
        try {
            res = Float.valueOf(value);
        } catch (Exception e) {
            Timber.e(e);
        }
        return res;
    }
}
