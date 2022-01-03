package com.emamagic.core.utils;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
        ToastyMode.MODE_TOAST_SUCCESS,
        ToastyMode.MODE_TOAST_WARNING,
        ToastyMode.MODE_TOAST_ERROR,
        ToastyMode.MODE_TOAST_DEFAULT
})

@Retention(RetentionPolicy.SOURCE)
public @interface ToastyMode {
    int MODE_TOAST_DEFAULT = 0;
    int MODE_TOAST_SUCCESS = 1;
    int MODE_TOAST_WARNING = 2;
    int MODE_TOAST_ERROR = 3;
}