package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw1.UiUtil;

public class Practice11PieChartView extends View {

    private Paint mPaint;
    private Paint mTextPaint;
    private RectF mRectF;
    private Path mPath;
    private float[] mValue;

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectF = new RectF();
        // 初始化 Path 对象
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(38);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mValue = new float[] {38, 11, 15, 46, 115, 135};
        mRectF.set(UiUtil.dip2px(getContext(), 70),
                UiUtil.dip2px(getContext(), 38),
                UiUtil.dip2px(getContext(), 274),
                UiUtil.dip2px(getContext(), 242));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        // 绘制扇形
        mPaint.setColor(Color.parseColor("#FFC107"));
        canvas.drawArc(mRectF, -50, 50, true, mPaint);
        mPaint.setColor(Color.parseColor("#9C27B0"));
        canvas.drawArc(mRectF, 2, 4, true, mPaint);
        mPaint.setColor(Color.parseColor("#9E9E9E"));
        canvas.drawArc(mRectF, 8, 4, true, mPaint);
        mPaint.setColor(Color.parseColor("#009688"));
        canvas.drawArc(mRectF, 14, 56, true, mPaint);
        mPaint.setColor(Color.parseColor("#2196F3"));
        canvas.drawArc(mRectF, 72, 104, true, mPaint);

        canvas.drawText("饼图", mRectF.centerX(), mRectF.bottom + UiUtil.dip2px(getContext(), 20), mTextPaint);

        mRectF.set(UiUtil.dip2px(getContext(), 62),
                UiUtil.dip2px(getContext(), 30),
                UiUtil.dip2px(getContext(), 266),
                UiUtil.dip2px(getContext(), 234));
        mPaint.setColor(Color.parseColor("#F44336"));
        canvas.drawArc(mRectF, 178, 132, true, mPaint);

    }
}
