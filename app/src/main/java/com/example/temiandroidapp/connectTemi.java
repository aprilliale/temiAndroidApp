package com.example.temiandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class connectTemi extends AppCompatActivity {
    TextView idNum;
    ImageButton nextbutton, backPrevScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_temi);

        idNum = findViewById(R.id.textSetUp);
        Intent i = getIntent();
        String ipNum = i.getStringExtra("ip_number");
        idNum.setText(ipNum+" Please select your team!");

        nextButtonOnListener();
        backplayClickListener();
    }

    private void backplayClickListener() {
        backPrevScreen = findViewById(R.id.backButton);

        backPrevScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(connectTemi.this, login.class);
                startActivity(i);
            }
        });
    }

    private void nextButtonOnListener() {
        nextbutton = findViewById(R.id.nextButton);

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(connectTemi.this, waitingRoom.class);
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