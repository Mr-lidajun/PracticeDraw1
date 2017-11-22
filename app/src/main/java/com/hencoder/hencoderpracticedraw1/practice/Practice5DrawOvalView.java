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

public class Practice5DrawOvalView extends View {

    private Paint mPaint;
    private RectF mRectF;

    public Practice5DrawOvalView(Context context) {
        super(context);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        mRectF.set(getWidth() / 2 - UiUtil.dip2px(getContext(), 80),
                getHeight() / 2 - UiUtil.dip2px(getContext(), 50),
                getWidth() / 2 + UiUtil.dip2px(getContext(), 80),
                getHeight() / 2 + UiUtil.dip2px(getContext(), 50));
        canvas.drawOval(mRectF, mPaint);
    }
}
