package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button selfDestruct;
    private Button lookBusy;
    private Switch useless;
    private ProgressBar iBusy;
    private int timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        timer = 10;
    }

    private void wireWidgets() {
        selfDestruct = findViewById(R.id.button_main_selfdestruct);
        lookBusy = findViewById(R.id.button_main_lookbusy);
        useless = findViewById(R.id.switch_main_useless);
        iBusy = findViewById(R.id.progressBar_main_useless);
    }

    private void setListeners() {
        selfDestruct.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                new CountDownTimer(10000,1000){


                    @Override
                    public void onTick(long l){

                        selfDestruct.setText(String.valueOf(timer));
                        timer--;
                        if(timer == 4){lookBusy.setVisibility(View.INVISIBLE);}
                        if(timer == 2){useless.setVisibility(View.INVISIBLE);}
                        if(timer == 0){selfDestruct.setVisibility(View.INVISIBLE);}
                    }


                    @Override
                    public void onFinish(){
                    finish();


                    }








                }.start();

            }
        }
        );
        lookBusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            iamBusy();
            }
        });
        useless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long l) {
                            if(!useless.isChecked()){
                                cancel();


                            }

                        }

                        @Override
                        public void onFinish() {
                        useless.setChecked(false);
                        }
                    }.start();
                }}










        });
        iBusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void iamBusy() {
        iBusy.setProgress(0);
        lookBusy.setVisibility(View.INVISIBLE);
        iBusy.setVisibility(View.VISIBLE);
        new CountDownTimer(10000,100){


            @Override
            public void onTick(long l){
                int i = 0;
                i++;
                iBusy.incrementProgressBy(i);

            }


            @Override
            public void onFinish(){

                iBusy.setVisibility(View.INVISIBLE);
                lookBusy.setVisibility(View.VISIBLE);

            }








        }.start();




    }

    }
