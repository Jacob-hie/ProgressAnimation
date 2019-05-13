package com.hie2j.progressanimation;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CircleProgressView circleProgressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleProgressView = findViewById(R.id.my_circle);
        int progress = 60;

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,progress);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) valueAnimator.getAnimatedValue();
                Log.e(TAG,"value = " + value);
                circleProgressView.setProgress(value);
            }
        });
        valueAnimator.start();
    }
}
