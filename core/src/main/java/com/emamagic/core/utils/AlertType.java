package com.emamagic.core.utils;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
        AlertType.INFO,
        AlertType.WARNING,
        AlertType.ERROR
})
@Retention(RetentionPolicy.SOURCE)
public @interface AlertType {
    int INFO = 0;
    int WARNING = 1;
    int ERROR = 2;
}
