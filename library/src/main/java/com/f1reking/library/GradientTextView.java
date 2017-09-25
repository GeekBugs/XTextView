/*
 * Copyright 2017 F1ReKing. https://github.com/f1reking
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.f1reking.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * author: huangyh
 * date: 2017/7/31 12:39
 * desc: 渐变色消失的TextView
 */

public class GradientTextView extends TextView {

    private static final String TAG = GradientTextView.class.getSimpleName();

    private LinearGradient mLinearGradient;
    private Paint mPaint;
    private Rect mTextBound = new Rect();
    private Rect mLastTextBound = new Rect();
    //渐变色长度
    private int gradientLength = 3;
    //渐变开始颜色
    private int startColor = Color.WHITE;
    //渐变结束颜色
    private int endColor = Color.TRANSPARENT;

    public GradientTextView(Context context) {
        this(context, null);
    }

    public GradientTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GradientTextView);
        gradientLength = typedArray.getInteger(R.styleable.GradientTextView_gradientLength, gradientLength);
        startColor = typedArray.getColor(R.styleable.GradientTextView_startColor, startColor);
        endColor = typedArray.getColor(R.styleable.GradientTextView_endColor, endColor);
        typedArray.recycle();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = getPaint();
        String content = getText().toString();
        if (content.length() > gradientLength + 1) {
            mPaint.getTextBounds(content, 0, content.length(), mTextBound);
            mPaint.getTextBounds(content, content.length() - gradientLength, content.length(), mLastTextBound);
            mLinearGradient = new LinearGradient(mTextBound.width() - mLastTextBound.width(), 0, mTextBound.width(), 0,
                new int[] { startColor, endColor }, null, Shader.TileMode.CLAMP);
            mPaint.setShader(mLinearGradient);
            canvas.drawText(content, getMeasuredWidth() / 2 - mTextBound.width() / 2,
                getMeasuredHeight() + mTextBound.height(), mPaint);
            postInvalidateDelayed(50);
        }
    }
}
