package com.example.intento_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.airbnb.lottie.LottieAnimationView;
import android.widget.TextView;

public class AnimationStart extends AppCompatActivity {

    private static final long DELAY_MILLIS = 5000; // 5 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_start);

        LottieAnimationView animationView = findViewById(R.id.animationView);
        TextView textViewWelcome = findViewById(R.id.textViewWelcome);


        animationView.setAnimation(R.raw.animation2);
        animationView.playAnimation();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(AnimationStart.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_MILLIS);
    }
}