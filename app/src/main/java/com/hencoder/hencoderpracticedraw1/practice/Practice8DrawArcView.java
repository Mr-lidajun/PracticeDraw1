package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw1.UiUtil;

public class Practice8DrawArcView extends View {

    private Paint mPaint;
    private RectF mRectF;

    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mRectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        mRectF.set(UiUtil.dip2px(getContext(), 76),
                UiUtil.dip2px(getContext(), 38),
                UiUtil.dip2px(getContext(), 304),
                UiUtil.dip2px(getContext(), 190));
        // 绘制扇形
        canvas.drawArc(mRectF, -100, 100, true, mPaint);
        // 绘制弧形
        canvas.drawArc(mRectF, 20, 140, false, mPaint);
        // 画线模式
        mPaint.setStyle(Paint.Style.STROKE);
        // 绘制不封口的弧形
        canvas.drawArc(mRectF, 180, 60, false, mPaint);
    }
}
