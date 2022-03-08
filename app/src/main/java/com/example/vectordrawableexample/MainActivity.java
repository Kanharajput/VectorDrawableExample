package com.example.vectordrawableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimatedVectorDrawable animatedVectorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);      // reference the imageview
    }

    @Override
    protected void onStart() {
        super.onStart();

        Drawable d = imageView.getDrawable();     // getting back the vector drawable

        if( d instanceof AnimatedVectorDrawable) {                // if d have the AnimatedVectorDrawable then we will run it
            animatedVectorDrawable = (AnimatedVectorDrawable) d;    // initialising the object of animatedVectorDrawable
            animatedVectorDrawable.start();
        }
    }
}