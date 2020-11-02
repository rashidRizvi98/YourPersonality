package com.example.quizfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class firstActivity extends AppCompatActivity {

    TextView titleGet, subtitleGet;
    Button btngetstarted;
    Animation btt, bttdua, bttlga, imgalpha;
    ImageView imgget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //import animation
        btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        bttdua = AnimationUtils.loadAnimation(this,R.anim.bttdua);
        bttlga = AnimationUtils.loadAnimation(this,R.anim.bttlga);
        imgalpha = AnimationUtils.loadAnimation(this,R.anim.imgalpha);

        titleGet = (TextView) findViewById(R.id.titleGet);
        subtitleGet = (TextView) findViewById(R.id.subtitleGet);
        btngetstarted = (Button) findViewById(R.id.btngetstarted);
        imgget = (ImageView) findViewById(R.id.imgget);

        //set animation
        titleGet.startAnimation(btt);
        subtitleGet.startAnimation(bttdua);
        btngetstarted.startAnimation(bttlga);
        imgget.startAnimation(imgalpha);

        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        //customize font
        titleGet.setTypeface(Vidaloka);
        btngetstarted.setTypeface(Vidaloka);
        subtitleGet.setTypeface(MLight);

        btngetstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(firstActivity.this,Dashboard.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}