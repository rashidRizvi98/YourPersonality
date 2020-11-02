package com.example.quizfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quizfrag.data.DbHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Question> mindQList,energyQList,natureQList,tacticsQList;



    int scoreM=0,scoreE=0,scoreN=0,scoreT=0;

    int qidM=0,qidE=0,qidN=0,qidT=0;

    Question currentMQ,currentEQ,currentNQ,currentTQ;



    TextView txtMindQuestion,txtEnergyQuestion,txtNatureQuestion,txtTacticsQuestion;


    RadioButton rdM1,rdM2,rdM3,rdM4,rdM5,        rdE1,rdE2,rdE3,rdE4,rdE5,
                rdN1,rdN2,rdN3,rdN4,rdN5,        rdT1,rdT2,rdT3,rdT4,rdT5;

    Button butNextM,butNextE,butNextN,butNextT;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final DbHelper db=new DbHelper(this);
        mindQList=db.getAllMindQuestions();

        currentMQ=mindQList.get(qidM);

        txtMindQuestion=findViewById(R.id.textViewM);
        rdM1=findViewById(R.id.radioM1);
        rdM2=findViewById(R.id.radioM2);
        rdM3=findViewById(R.id.radioM3);
        rdM4=findViewById(R.id.radioM4);
        rdM5=findViewById(R.id.radioM5);
        butNextM=findViewById(R.id.button1);

        setMindQuestionView();

        butNextM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=findViewById(R.id.radioGroupM);
                RadioButton answer=findViewById(grp.getCheckedRadioButtonId());

                grp.clearCheck();
                if (answer==rdM1)
                {
                    scoreM=scoreM+3;

                    Log.d("scoreM","Your score"+scoreM);
                }
                else
                if(answer==rdM2)
                {
                    scoreM=scoreM+2;
                    Log.d("scoreM","Your score"+scoreM);

                }
                else
                if(answer==rdM4)
                {
                    scoreM=scoreM-2;
                    Log.d("scoreM","Your score"+scoreM);

                }
                else
                if(answer==rdM5)
                {
                    scoreM=scoreM-3;
                    Log.d("scoreM","Your score"+scoreM);

                }


                if(qidM<5){
                    currentMQ=mindQList.get(qidM);
                    setMindQuestionView();
                }

                else{


                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    //now get Editor
                    SharedPreferences.Editor editor = sharedPref.edit();
                    //put your value
                    editor.putInt("scoreM", scoreM);

                    //commits your edits
                    editor.commit();



                    setContentView(R.layout.activity_main2);


                    energyQList=db.getAllEnergyQuestions();

                    currentEQ=energyQList.get(qidE);

                    txtEnergyQuestion=findViewById(R.id.textViewE);
                    rdE1=findViewById(R.id.radioE1);
                    rdE2=findViewById(R.id.radioE2);
                    rdE3=findViewById(R.id.radioE3);
                    rdE4=findViewById(R.id.radioE4);
                    rdE5=findViewById(R.id.radioE5);
                    butNextE=findViewById(R.id.buttonE);

                    setEnergyQuestionView();

                    butNextE.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RadioGroup grpE=findViewById(R.id.radioGroupE);
                            RadioButton answerE=findViewById(grpE.getCheckedRadioButtonId());
                            grpE.clearCheck();

                            if (answerE==rdE1)
                            {
                                scoreE=scoreE+3;

                                Log.d("scoreE","Your score"+scoreE);
                            }
                            else
                            if(answerE==rdE2)
                            {
                                scoreE=scoreE+2;
                                Log.d("scoreE","Your score"+scoreE);

                            }
                            else
                            if(answerE==rdE4)
                            {
                                scoreE=scoreE-2;
                                Log.d("scoreE","Your score"+scoreE);

                            }
                            else
                            if(answerE==rdE5)
                            {
                                scoreE=scoreE-3;
                                Log.d("scoreE","Your score"+scoreE);

                            }


                            if(qidE<5){
                                currentEQ=energyQList.get(qidE);
                                setEnergyQuestionView();
                            }else{

                                SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                                //now get Editor
                                SharedPreferences.Editor editor = sharedPref2.edit();
                                //put your value
                                editor.putInt("scoreE", scoreE);

                                //commits your edits
                                editor.commit();







                                setContentView(R.layout.activity_main3);



                                natureQList=db.getAllNatureQuestions();

                                currentNQ=natureQList.get(qidN);

                                txtNatureQuestion=findViewById(R.id.textViewN);
                                rdN1=findViewById(R.id.radioN1);
                                rdN2=findViewById(R.id.radioN2);
                                rdN3=findViewById(R.id.radioN3);
                                rdN4=findViewById(R.id.radioN4);
                                rdN5=findViewById(R.id.radioN5);
                                butNextN=findViewById(R.id.buttonN);

                                setNatureQuestionView();

                                butNextN.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        RadioGroup grpN=findViewById(R.id.radioGroupN);
                                        RadioButton answerN=findViewById(grpN.getCheckedRadioButtonId());
                                        grpN.clearCheck();

                                        if (answerN==rdN1)
                                        {
                                            scoreN=scoreN+3;

                                            Log.d("scoreN","Your score"+scoreN);
                                        }
                                        else
                                        if(answerN==rdN2)
                                        {
                                            scoreN=scoreN+2;
                                            Log.d("scoreN","Your score"+scoreN);

                                        }
                                        else
                                        if(answerN==rdN4)
                                        {
                                            scoreN=scoreN-2;
                                            Log.d("scoreN","Your score"+scoreN);

                                        }
                                        else
                                        if(answerN==rdN5)
                                        {
                                            scoreN=scoreN-3;
                                            Log.d("scoreN","Your score"+scoreN);

                                        }


                                        if(qidN<5){
                                            currentNQ=natureQList.get(qidN);
                                            setNatureQuestionView();
                                        }else{
                                            SharedPreferences sharedPref3 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                                            //now get Editor
                                            SharedPreferences.Editor editor = sharedPref3.edit();
                                            //put your value
                                            editor.putInt("scoreN", scoreN);

                                            //commits your edits
                                            editor.commit();




                                            setContentView(R.layout.activity_main4);



                                            tacticsQList=db.getAllTacticsQuestions();

                                            currentTQ=tacticsQList.get(qidT);

                                            txtTacticsQuestion=findViewById(R.id.textViewT);
                                            rdT1=findViewById(R.id.radioT1);
                                            rdT2=findViewById(R.id.radioT2);
                                            rdT3=findViewById(R.id.radioT3);
                                            rdT4=findViewById(R.id.radioT4);
                                            rdT5=findViewById(R.id.radioT5);
                                            butNextT=findViewById(R.id.buttonT);

                                            setTacticsQuestionView();

                                            butNextT.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    RadioGroup grpT=findViewById(R.id.radioGroupT);
                                                    RadioButton answerT=findViewById(grpT.getCheckedRadioButtonId());
                                                    grpT.clearCheck();

                                                    if (answerT==rdT1)
                                                    {
                                                        scoreT=scoreT+3;

                                                        Log.d("scoreT","Your score"+scoreT);
                                                    }
                                                    else
                                                    if(answerT==rdT2)
                                                    {
                                                        scoreT=scoreT+2;
                                                        Log.d("scoreT","Your score"+scoreT);

                                                    }
                                                    else
                                                    if(answerT==rdT4)
                                                    {
                                                        scoreT=scoreT-2;
                                                        Log.d("scoreT","Your score"+scoreT);

                                                    }
                                                    else
                                                    if(answerT==rdT5)
                                                    {
                                                        scoreT=scoreT-3;
                                                        Log.d("scoreT","Your score"+scoreT);

                                                    }


                                                    if(qidT<5){
                                                        currentTQ=tacticsQList.get(qidT);
                                                        setTacticsQuestionView();
                                                    }else{


                                                        SharedPreferences sharedPref4 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                                                        //now get Editor
                                                        SharedPreferences.Editor editor = sharedPref4.edit();
                                                        //put your value
                                                        editor.putInt("scoreT", scoreT);

                                                        //commits your edits
                                                        editor.commit();



                                                        Intent intentR=new Intent(MainActivity.this,ResultActivity.class);
                                                        startActivity(intentR);
                                                        finish();



                                                    }
                                                }
                                            });




                                        }
                                    }
                                });



                            }
                        }
                    });





                }
            }
        });




    }


    private void setMindQuestionView()
    {
        txtMindQuestion.setText(currentMQ.getQUESTION());
        qidM++;
    }


    private void setEnergyQuestionView()
    {
        txtEnergyQuestion.setText(currentEQ.getQUESTION());
        qidE++;
    }


    private void setNatureQuestionView()
    {
        txtNatureQuestion.setText(currentNQ.getQUESTION());
        qidN++;
    }

    private void setTacticsQuestionView()
    {
        txtTacticsQuestion.setText(currentTQ.getQUESTION());
        qidT++;
    }



}