package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.common.UIUtils;

public class Practice11PieChartView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        mPaint.setStyle(Paint.Style.FILL);


        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int radius = UIUtils.dip2Px(getContext(), 110);

        canvas.translate(width / 2, height / 2);

        mPaint.setColor(Color.parseColor("#ffc107"));
        canvas.drawArc(-radius, -radius, radius, radius, -45, 44, true, mPaint);

        mPaint.setColor(Color.parseColor("#bd71a1"));
        canvas.drawArc(-radius, -radius, radius, radius, 1, 4, true, mPaint);

        mPaint.setColor(Color.parseColor("#9e9e9e"));
        canvas.drawArc(-radius, -radius, radius, radius, 6, 9, true, mPaint);

        mPaint.setColor(Color.parseColor("#009688"));
        canvas.drawArc(-radius, -radius, radius, radius, 18, 60, true, mPaint);

        mPaint.setColor(Color.parseColor("#2196f3"));
        canvas.drawArc(-radius, -radius, radius, radius, 80, 90, true, mPaint);

        canvas.translate(-UIUtils.dip2Px(getContext(), 8), -UIUtils.dip2Px(getContext(), 8));
        mPaint.setColor(Color.parseColor("#f44336"));
        canvas.drawArc(-radius, -radius, radius, radius, 171, 142, true, mPaint);
    }
}
