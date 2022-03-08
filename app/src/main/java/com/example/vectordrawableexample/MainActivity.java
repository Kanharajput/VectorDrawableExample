package com.example.vectordrawableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView tierImage;
    private AnimatedVectorDrawable animatedVectorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);      // reference the imageview
        imageView.setBackgroundResource(R.drawable.animatedvectordrawable);

        tierImage = findViewById(R.id.tier_image);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Drawable d = imageView.getBackground();     // getting back the vector drawable , you can also directly cast it to AnimatedVectorDrawable and start animation directly

        if( d instanceof AnimatedVectorDrawable) {                // if d have the AnimatedVectorDrawable then we will run it
            animatedVectorDrawable = (AnimatedVectorDrawable) d;    // initialising the object of animatedVectorDrawable
            animatedVectorDrawable.start();
        }
    }

    // animating the tier image to move with rotation
    public void moveTier(View view) {
        ObjectAnimator rotateTier = ObjectAnimator.ofFloat(tierImage,"rotation",360f);
        rotateTier.setDuration(4000);
        ObjectAnimator travelHorizontal = ObjectAnimator.ofFloat(tierImage,"translationX",720f);
        travelHorizontal.setDuration(4000);
        AnimatorSet motion = new AnimatorSet();
        motion.playTogether(rotateTier,travelHorizontal);
        motion.start();
    }
}