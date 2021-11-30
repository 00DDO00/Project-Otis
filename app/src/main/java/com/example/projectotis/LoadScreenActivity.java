package com.example.projectotis;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LoadScreenActivity extends AppCompatActivity
{

    int btnCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadscreen);

        ImageView iv = (ImageView) findViewById(R.id.gifImgView);

        //To play with the logo until the app loads. Should let you rotate image as you click it,
        // but currently DOES NOT WORK.
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCounter++;


                if (btnCounter == 1)
                {
                    iv.setVisibility(View.GONE);
                }
                else if (btnCounter == 2)
                {
                    iv.setVisibility(View.VISIBLE);
                    btnCounter = 0;
                }


            }

        });

        new CountDownTimer(5000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                //Gives symmetry effect.

            }

            public void onFinish()
            {
                startActivity(new Intent(LoadScreenActivity.this, com.example.projectotis.SignUpActivity.class));

            }
        }.start();
    }


}
