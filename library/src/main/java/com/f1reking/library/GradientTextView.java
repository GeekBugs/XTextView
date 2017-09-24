package com.f1reking.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * author: huangyh
 * date: 2017/7/31 12:39
 * desc: 渐变色消失的TextView
 */

public class GradientTextView extends TextView {

    private LinearGradient mLinearGradient;
    private Paint mPaint;
    private Rect mTextBound = new Rect();
    private Rect mLastTextBound = new Rect();

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = getPaint();
        String content = getText().toString();
        if (content.length() > 4) {
            mPaint.getTextBounds(content, 0, content.length(), mTextBound);
            mPaint.getTextBounds(content, content.length() - 3, content.length(), mLastTextBound);
            mLinearGradient = new LinearGradient(mTextBound.width() - mLastTextBound.width(), 0, mTextBound.width(), 0,
                new int[] { Color.WHITE, Color.TRANSPARENT }, null, Shader.TileMode.CLAMP);
            mPaint.setShader(mLinearGradient);
            canvas.drawText(content, getMeasuredWidth() / 2 - mTextBound.width() / 2,
                getMeasuredHeight() + mTextBound.height(), mPaint);
            postInvalidateDelayed(50);
        }
    }
}
