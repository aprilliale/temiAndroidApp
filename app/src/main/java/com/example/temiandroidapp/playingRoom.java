package com.example.temiandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class playingRoom extends AppCompatActivity {

    ImageButton buttonUp, buttonDown, buttonLeft, buttonRight, buttonForward, buttonBackward, buttonShot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_room);

        //button code
        upListener();
        downListener();
        leftListener();
        rightListener();
        forwardListener();
        backwardListener();
        shotListener();
    }

    private void upListener() {
        buttonUp = findViewById(R.id.buttonUP);
    }

    private void downListener() {
        buttonDown = findViewById(R.id.buttonDown);

    }

    private void leftListener() {
        buttonLeft = findViewById(R.id.buttonLeft);
    }

    private void rightListener() {
        buttonRight = findViewById(R.id.buttonRight);

    }

    private void forwardListener() {
        buttonForward = findViewById(R.id.buttonForward);

    }

    private void backwardListener() {
        buttonBackward = findViewById(R.id.buttonBackward);
    }

    private void shotListener() {
        buttonShot = findViewById(R.id.buttonShot);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}