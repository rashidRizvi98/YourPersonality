package com.example.quizfrag;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizfrag.data.DbHelper;

public class Dashboard extends AppCompatActivity {

    TextView titleGet1, subtitleGet1;
    Button btntaketest;
    Animation btt, bttdua, bttlga, imgalpha;
    ImageView imgget1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //import animation
        btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        bttdua = AnimationUtils.loadAnimation(this,R.anim.bttdua);
        bttlga = AnimationUtils.loadAnimation(this,R.anim.bttlga);
        imgalpha = AnimationUtils.loadAnimation(this,R.anim.imgalpha);

        btntaketest = (Button) findViewById(R.id.btntaketest);


        titleGet1 = (TextView) findViewById(R.id.titleGet1);
        subtitleGet1 = (TextView) findViewById(R.id.subtitleGet1);
        imgget1 = (ImageView) findViewById(R.id.imgget1);

        //set animation
        titleGet1.startAnimation(btt);
        subtitleGet1.startAnimation(bttdua);
        btntaketest.startAnimation(bttlga);
        imgget1.startAnimation(imgalpha);

        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        //customize font
        btntaketest.setTypeface(Vidaloka);
        titleGet1.setTypeface(Vidaloka);
        subtitleGet1.setTypeface(MLight);

        btntaketest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Dashboard.this,MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }





}