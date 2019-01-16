package com.andrstudy.imageview;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by qf090 on 2018-06-12.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by user on 2018-06-12.
 */

public class TouchImageView extends AppCompatImageView {

    public TouchImageView(Context context) {
        super(context);
    }

    public TouchImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setARGB(255, 255, 0, 0);
        canvas.drawCircle(100, 100, 20,p);
    }
}