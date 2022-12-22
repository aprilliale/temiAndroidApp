package com.example.temiandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class waitingRoom extends AppCompatActivity {

    ImageButton blue, red, backPrevScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_room);

        blueplayClickListener();
        redplayClickListener();
        backplayClickListener();
    }

    private void backplayClickListener() {
        backPrevScreen = findViewById(R.id.backButton);

        backPrevScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(waitingRoom.this, connectTemi.class);
                startActivity(i);
            }
        });
    }

    private void redplayClickListener() {
        red = findViewById(R.id.redTeam);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(waitingRoom.this, playingRoom.class);
                startActivity(i);
            }
        });
    }

    private void blueplayClickListener() {
        blue = findViewById(R.id.blueTeam);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(waitingRoom.this, playingRoom.class);
                startActivity(i);
            }
        });
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