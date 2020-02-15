package com.vouliont.team.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AnimationDrawable dancingAnimation;
    private Button animateButton;

    private boolean isAnimating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ImageView animatedDancingImageView = findViewById(R.id.animated_dancing_image_view);
        animatedDancingImageView.setBackgroundResource(R.drawable.animated_dancing);
        dancingAnimation = (AnimationDrawable) animatedDancingImageView.getBackground();

        animateButton = findViewById(R.id.animate_button);
        animateButton.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isAnimating", isAnimating);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isAnimating = savedInstanceState.getBoolean("isAnimating");
        toggleDancingAnimation(isAnimating);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.animate_button:
                toggleDancingAnimation();
                break;
            default:
                break;
        }
    }

    private void toggleDancingAnimation() {
        toggleDancingAnimation(!isAnimating);
    }

    private void toggleDancingAnimation(boolean isAnimating) {
        this.isAnimating = isAnimating;
        toggleButtonText();

        if (isAnimating) {
            dancingAnimation.start();
        } else {
            dancingAnimation.stop();
        }
    }

    private void toggleButtonText() {
        int textId = isAnimating ? R.string.pause_dancing : R.string.animate_dancing;
        animateButton.setText(textId);
    }
}
