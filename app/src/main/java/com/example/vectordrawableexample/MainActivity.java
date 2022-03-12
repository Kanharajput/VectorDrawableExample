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
    private ImageView pausePlay;
    private boolean isPlay = true;   // for moving between the state of play and pause

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);      // reference the imageview
        imageView.setBackgroundResource(R.drawable.animatedvectordrawable);

        tierImage = findViewById(R.id.tier_image);

        pausePlay = findViewById(R.id.puase_play_imageview);
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

    // created with shape shifter  so here pass drawable with setImageResource and also set it in xml code
    public void PausePlayReversible(View view) {

        if(isPlay) {
            // call the method play to pause
            playToPause();
            isPlay = false;
        }

        else {
            PauseToPlay();
            isPlay = true;
        }

    }

    private void playToPause() {
        // setting up the image Resource of play to pause
        pausePlay.setImageResource(R.drawable.avd_play_pause);

        Drawable drawable = pausePlay.getDrawable();

        if(drawable instanceof AnimatedVectorDrawable) {
            animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            animatedVectorDrawable.start();
        }
    }

    private void PauseToPlay() {
        // this time set the resource of the pause to play avd
        pausePlay.setImageResource(R.drawable.avd_pause_play);

        Drawable drawable = pausePlay.getDrawable();

        if(drawable instanceof AnimatedVectorDrawable) {
            animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            animatedVectorDrawable.start();
        }
    }

}