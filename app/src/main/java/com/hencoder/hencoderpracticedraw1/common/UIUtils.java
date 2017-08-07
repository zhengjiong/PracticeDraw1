package com.hencoder.hencoderpracticedraw1.common;

import android.content.Context;

/**
 * CreateTime: 17/8/7  16:43
 *
 * @author 郑炯
 */
public class UIUtils {

    public static int dip2Px(Context context, float dip) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (density * dip + 0.5f);
    }
}
