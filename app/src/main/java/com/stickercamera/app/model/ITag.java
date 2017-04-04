package com.stickercamera.app.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by imxqd on 17-4-4.
 */

public interface ITag {
    int TYPE_TIP = 0;
    int TYPE_ADDR = 1;
    int TYPE_RECORD = 2;
    int TYPE_LINK = 3;

    @IntDef({
            TYPE_TIP,
            TYPE_ADDR,
            TYPE_RECORD,
            TYPE_LINK
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface Type{}

    @Type
    int getType();
}
