package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

import java.util.Map;

public class Practice2DrawCircleView extends View {
    private Paint mPaint;
    private int radius;

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        radius = getResources().getDimensionPixelOffset(R.dimen.radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆


        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        //1.黑色实心圆
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(width / 4, height / 4, radius, mPaint);

        //2.空心
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width / 4 * 3, height / 4, radius, mPaint);

        //3.蓝色实心圆
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#4a90e2"));
        canvas.drawCircle(width / 4, height / 4 * 3, radius, mPaint);

        //4.线宽为 20 的空心圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(width / 4 * 3, height / 4 * 3, radius, mPaint);
    }
}
