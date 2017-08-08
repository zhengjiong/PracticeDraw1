package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
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

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        //1.画坐标系
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);//如果是fill, 坐标系线条将不会显示出来
        mPaint.setStrokeWidth(2);

        Path path = new Path();
        int margin = UIUtils.dip2Px(getContext(), 34);
        int bottomMargin = UIUtils.dip2Px(getContext(), 50);
        path.moveTo(margin, 0);
        path.lineTo(margin, getMeasuredHeight() - bottomMargin);
        path.lineTo(getMeasuredWidth(), getMeasuredHeight() - margin - bottomMargin);
        canvas.drawPath(path, mPaint);

        //2.画底部文字
        mPaint.setTextSize(UIUtils.dip2Px(getContext(), 18));
        mPaint.setStyle(Paint.Style.FILL);
        Rect rect = new Rect();
        mPaint.getTextBounds("直方图", 0, 3, rect);
        canvas.drawText(
                "直方图",
                width / 2 - rect.width() / 2,
                height - rect.height(),
                mPaint
        );


        //3. 画柱状图
        mPaint.setColor(Color.parseColor("#72b916"));
        Path rectPath = new Path();
        for (int i = 0; i < 7; i++) {
            Rect columnarRect = new Rect();
            if (i == 0) {
                columnarRect.left = 8;
            } else {
                columnarRect.
            }
            rectPath.addRect();
        }
        rectPath.addRect();
        canvas.drawPath();
    }
}
