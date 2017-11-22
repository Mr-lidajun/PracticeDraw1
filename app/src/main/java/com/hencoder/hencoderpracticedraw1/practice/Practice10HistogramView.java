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

public class Practice10HistogramView extends View {

    private Paint mPaint;
    private RectF mRectF;
    private Path mPath;
    private Paint mTextPaint;
    private Paint mRectPaint;
    private static final String[] mTextArray = new String[]{"Froyo", "GB", "ICS", "JB", "kitkat", "L", "M"};
    private float[] mValue;
    private int mWidthHistogram;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectF = new RectF();
        // 初始化 Path 对象
        mPath = new Path();
        mPaint = new Paint();
        mRectPaint = new Paint();
        mTextPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(UiUtil.dip2px(getContext(), 0.6f));

        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(24);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mRectPaint.setAntiAlias(true);
        mRectPaint.setColor(Color.parseColor("#72B916"));
        mRectPaint.setStyle(Paint.Style.FILL);

        mPath.moveTo(UiUtil.dip2px(getContext(), 62), UiUtil.dip2px(getContext(), 38));
        // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
        // 当前位置：所谓当前位置，即最后一次调用画 Path 的方法的终点位置。初始值为原点 (0, 0)。
        mPath.rLineTo(0, UiUtil.dip2px(getContext(), 160));
        mPath.rLineTo(UiUtil.dip2px(getContext(), 290), 0);

        // 初始化数据
        mValue = new float[] {0.06f, 0.15f, 0.16f, 0.46f, 0.8f, 0.9f, 0.38f};
        mWidthHistogram = UiUtil.dip2px(getContext(), 30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        canvas.drawPath(mPath, mPaint);

        // 画文字
        for (int i = 0; i < 7; i++) {
            // 画矩形
            // 0: 70dp
            // 1: 26dp + 70dp = 96dp
            // 2: 52dp + 70dp = 122dp
            float offset = i * UiUtil.dip2px(getContext(), 10);
            float left = i * mWidthHistogram + UiUtil.dip2px(getContext(), 70) + offset;
            float rectHeight = UiUtil.dip2px(getContext(), 196) - UiUtil.dip2px(getContext(), 160) * mValue[i];
            mRectF.set(left, rectHeight, left + mWidthHistogram,
                    UiUtil.dip2px(getContext(), 198));
            canvas.drawRect(mRectF, mRectPaint);

            Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
            //为基线到字体上边框的距离,即上图中的top
            float top = fontMetrics.top;
            //为基线到字体下边框的距离,即上图中的bottom
            float bottom = fontMetrics.bottom;
            // 基线中间点的y轴计算公式，参考： android canvas drawText()文字居中（http://blog.csdn.net/zly921112/article/details/50401976）
            float baseLineY = mRectF.bottom - top - bottom;
            canvas.drawText(mTextArray[i], mRectF.centerX(), baseLineY, mTextPaint);
        }

        mTextPaint.setTextSize(38);
        canvas.drawText("直方图", getWidth() / 2, mRectF.bottom + UiUtil.dip2px(getContext(), 40), mTextPaint);
    }
}
