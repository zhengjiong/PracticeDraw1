package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形


        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);

        /**
         * 这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
         * 少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数；
         * 而多出来的这个 forceMoveTo 参数的意思是，true:绘制是要「抬一下笔移动过去」，false: 还是「直接拖着笔过去」，区别在于是否留下移动的痕迹。
         */
        path.arcTo(
                200, 200, 400, 400,
                -225,
                225,
                true// 强制移动到弧形起点（无痕迹）
        );
        path.arcTo(
                400, 200, 600, 400,
                -180,
                225,
                false//如果这里换成true, 就是抬笔了,相当于是另外一个图形了, 下面的close将不会对之前画的图形起作用
        );
        path.lineTo(400, 542);
        path.close();//封闭当前子图形

        canvas.drawPath(path, paint);
    }
}
