package com.example.uselessbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch useless;
    private Button destruct;
    private Button lookBusy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        updateGameDisplay();

    }

    private void updateGameDisplay() {
        useless.setChecked(true);
    }

    private void setListeners() {
        useless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
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
                }

//                if (isChecked) {
//                    Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Off", Toast.LENGTH_SHORT).show();
//                }

            }
        });

        destruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(1000, 1000) {

                    public void onTick(long millisUnitFinished){
                        destruct.setText("seconds remaining: " + millisUnitFinished / 1000);
                    }
                    public void onFinish() {
                        destruct.setText("BOOM!");
                        finish();
                    }
                };
            }
        });
    }


    private void wireWidgets() {
        useless = findViewById(R.id.switch_main_useless);
        destruct = findViewById(R.id.button_main_destruct);
    }


}
