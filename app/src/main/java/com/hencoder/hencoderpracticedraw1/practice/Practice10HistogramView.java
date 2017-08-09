package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.common.UIUtils;

import static android.R.attr.y;

public class Practice10HistogramView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

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
        int leftMargin = UIUtils.dip2Px(getContext(), 34);
        int bottomMargin = UIUtils.dip2Px(getContext(), 50);
        int horizontalLineWidth = getMeasuredWidth() - 2 * leftMargin;

        mTextPaint.setTextSize(UIUtils.dip2Px(getContext(), 10));
        mTextPaint.setColor(Color.WHITE);

        //1.画坐标系
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);//如果是fill, 坐标系线条将不会显示出来
        mPaint.setStrokeWidth(2);

        Path path = new Path();

        path.moveTo(leftMargin, 0);
        path.rLineTo(0, getMeasuredHeight() - bottomMargin);

        path.rLineTo(horizontalLineWidth, 0);
        canvas.drawPath(path, mPaint);

        //2.画底部文字
        mPaint.setTextSize(UIUtils.dip2Px(getContext(), 16));
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
        mPaint.setStyle(Paint.Style.FILL);
        Path columnarPath = new Path();
        //对addRect不起作用,只对线条的起点起作用
        columnarPath.moveTo(leftMargin, getMeasuredHeight() - bottomMargin);
        float left = leftMargin;
        int rectWidth = (horizontalLineWidth - 16 * 8) / 7;
        int bottom = getMeasuredHeight() - bottomMargin - 2;
        for (int i = 0; i < 7; i++) {
            RectF columnarRect = new RectF();
            columnarRect.left = left + 16;
            columnarRect.bottom = bottom;
            columnarRect.right = columnarRect.left + rectWidth;
            columnarRect.top = (float) (columnarRect.bottom - Math.random() * 500);
            columnarPath.addRect(columnarRect, Path.Direction.CW);
            left = columnarRect.right;

            //4. 画柱状图下的文字
            int textX = Math.round(columnarRect.left + (columnarRect.right - columnarRect.left) / 2);
            String s = String.valueOf(i);
            Rect boundRect = new Rect();
            mTextPaint.getTextBounds(s, 0, s.length(), boundRect);
            int textY = getMeasuredHeight() - bottomMargin + boundRect.height() + UIUtils.dip2Px(getContext(), 2);
            canvas.drawText(s, textX, textY, mTextPaint);
        }
        canvas.drawPath(columnarPath, mPaint);

    }
}
