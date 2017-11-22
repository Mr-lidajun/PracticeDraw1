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

public class Practice9DrawPathView extends View {

    private Paint mPaint;
    private RectF mRectF;
    private Path mPath;

    public Practice9DrawPathView(Context context) {
        super(context);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectF = new RectF();
        // 初始化 Path 对象
        mPath = new Path();
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        mRectF.set(UiUtil.dip2px(getContext(), 76),
                UiUtil.dip2px(getContext(), 76),
                UiUtil.dip2px(getContext(), 152),
                UiUtil.dip2px(getContext(), 152));
        // 使用 path 对图形进行描述
        mPath.addArc(mRectF, -225, 225);

        mRectF.set(UiUtil.dip2px(getContext(), 152),
                UiUtil.dip2px(getContext(), 76),
                UiUtil.dip2px(getContext(), 228),
                UiUtil.dip2px(getContext(), 152));
        mPath.arcTo(mRectF, -180, 225, false);
        mPath.lineTo(UiUtil.dip2px(getContext(), 152), UiUtil.dip2px(getContext(), 206));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        canvas.drawPath(mPath, mPaint);
    }
}
