package com.example.temiandroidapp;

import static android.view.Gravity.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton startButton, settingButton,exitButton;
    Dialog popUp;
    Button musicButton, closePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_layout);

        //pop-up setting
        popUp = new Dialog(MainActivity.this);
        popUp.setContentView(R.layout.popup_setting);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1){
            popUp.getWindow().setBackgroundDrawable(getDrawable(R.drawable.popup_background));
        }

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

        lp.copyFrom(popUp.getWindow().getAttributes());
        lp.width = 900;
        lp.height = 500;
        popUp.getWindow().setAttributes(lp);

        //popUp.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        popUp.getWindow().getAttributes().windowAnimations = R.style.animation;

        musicButton = popUp.findViewById(R.id.soundON);
        closePopup = popUp.findViewById(R.id.closePopup);

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "music on", Toast.LENGTH_SHORT).show();
            }
        });

        closePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                popUp.dismiss();
            }
        });

        settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUp.show();
            }
        });

        addListenerOnButton(); //button function
    }

    // BUTTON CODE
    private void addListenerOnButton() {

        startButton = findViewById(R.id.startButton);
        exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });


        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("Do you want to exit?").setCancelable(false).
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                System.exit(0);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
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

