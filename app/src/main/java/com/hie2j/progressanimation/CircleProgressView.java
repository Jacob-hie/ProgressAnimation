package com.hie2j.progressanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yls on 2019/5/13.
 */

public class CircleProgressView extends View{
    private Paint paint = new Paint();

    private int progress;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setAntiAlias(true);
        paint.setDither(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(270,300,220,paint);

        paint.setStrokeWidth(20);
        paint.setColor(Color.BLUE);
        canvas.drawArc(50,80,490,520,270,
                360 * progress / 100,false,paint);

        //运动消耗
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("运动消耗",170,200,paint);
        canvas.drawText(progress+"%",220,300,paint);
        canvas.drawText("Kcal",220,380,paint);
    }
}
