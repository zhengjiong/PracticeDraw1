package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.common.UIUtils;

public class Practice10HistogramView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        //1.画坐标系
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(6);

        Path path = new Path();
        int leftMargin = UIUtils.dip2Px(getContext(), 30);
        int bottomMargin = UIUtils.dip2Px(getContext(), 50);
        path.moveTo(leftMargin, 0);
        path.lineTo(leftMargin, getMeasuredHeight() - bottomMargin);

        canvas.drawPath(path, mPaint);

    }
}
