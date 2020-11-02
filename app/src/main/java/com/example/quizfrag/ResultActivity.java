package com.example.quizfrag;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizfrag.data.DbHelper;

public class ResultActivity extends AppCompatActivity {

    TextView txtPersonality,txtCareers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        txtPersonality=(TextView)findViewById(R.id.textResult);
        txtCareers=(TextView)findViewById(R.id.textCareer);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int scoreM = sharedPref.getInt("scoreM", 0);

        int scoreE = sharedPref.getInt("scoreE", 0);

        int scoreN = sharedPref.getInt("scoreN", 0);

        int scoreT = sharedPref.getInt("scoreT", 0);

        String personalityType=testMind(scoreM)+testEnergy(scoreE)+testNature(scoreN)+testTactics(scoreT);


        txtPersonality.setText( personalityType+personalityName(personalityType));
        txtCareers.setText("We believe,these are the suitable careers for you"+personalityCareer(personalityType));




    }




    public String testMind(int mind)
    {
        int compare = 0;
        if(mind > compare)
        { return "I"; }
        else
        { return "E"; }
    }
    public String testEnergy(int energy)
    {
        int compare = 0;
        if(energy > compare)
        { return "S"; }
        else
        { return "N"; }
    }

    public String testNature(int nature)
    {
        int compare = 0;
        if(nature > compare)
        { return "F"; }
        else
        { return "T"; }
    }
    public String testTactics(int tactics)
    {
        int compare = 0;
        if(tactics > compare)
        { return "P"; }
        else
        { return "J"; }
    }

    public String personalityName(String ptype)
    {
        switch(ptype) {
            case "ISTJ": return "-The Inspector";

            case "ISTP": return "-The Crafter";

            case "ISFJ": return "-The Protector";

            case "ISFP": return "-The Artist";

            case "INFJ": return "-The Advocate";

            case "INFP": return "-The Mediator";

            case "INTJ": return "-The Architect";

            case "INTP": return "-The Thinker";

            case "ESTP": return "-The Persuader";

            case "ESTJ": return "-The Director";

            case "ESFP": return "-The Performer";

            case "ESFJ": return "-The Caregiver";

            case "ENFP": return "-The Champion";

            case "ENFJ": return " - The Giver";

            case "ENTP": return "-The Debater";

            default: return "-The Commander";

        }


    }




    public String personalityCareer(String ptype)
    {
        switch(ptype) {
            case "ISTJ": return "\n" +"\n" +"    Accountant\n" + "    Computer Programmer\n" + "    Dentist\n" +"    Doctor\n" +"    Librarian\n" +
                        "    Lawyer\n" +"    Police Officer or Detective\n" +"    Military Leader";


            case "ISTP":
                return "\n" + "\n" + "    Forensic science\n" + "    Engineering\n" + "    Mechanics\n" + "    Computer programming\n" + "    Carpentry\n" +
                        "    Law enforcement\n" + "    Software engineer\n" + "    Video game designer\n" + "    Electrician\n" + "    Scientist\n" + "    Pilot\n" +
                        "    Firefighter";

            case "ISFJ":
                return "\n" + "\n" + "    Social worker\n" + "    Counselor\n" + "    Nurse\n" + "    Paralegal\n" + "    Bookkeeper\n" +
                        "    Child care provider\n" + "    Office Manager\n" + "    Administrator\n" + "    Teacher\n" + "    Banker\n" + "    Accountant";

            case "ISFP":
                return "\n" + "\n" + "    Artist\n" + "    Composer or musician\n" + "    Chef\n" + "    Designer\n" + "    Forest ranger\n" + "    Nurse\n" +
                        "    Naturalist\n" + "    Pediatrician\n" + "    Psychologist\n" + "    Social worker\n" + "    Teacher\n" + "    Veterinarian";

            case "INFJ":
                return "\n" + "\n" + "    Artist\n" + "    Actor\n" + "    Entrepreneur\n" + "    Religious worker\n" + "    Musician\n" +
                        "    Librarian\n" + "    Counselor\n" + "    Psychologist\n" + "    Writer\n" + "    Teacher\n" + "    Photographer";

            case "INFP":
                return "\n" + "\n" + "    Artist\n" + "    Counselor\n" + "    Graphic Designer\n" + "    Librarian\n" +
                        "    Psychologist\n" + "    Physical Therapist\n" + "    Social Worker\n" + "    Writer";

            case "INTJ":
                return "\n" + "\n" + "    Scientist\n" + "    Mathematician\n" + "    Engineer\n" + "    Dentist\n" +
                        "    Doctor\n" + "    Teacher\n" + "    Judge\n" + "    Lawyer";

            case "INTP":
                return "\n" + "\n" + "    Chemist\n" + "    Physicist\n" + "    Computer programmer\n" + "    Forensic scientist\n" +
                        "    Engineer\n" + "    Mathematician\n" + "    Pharmacist\n" + "    Software developer\n" + "    Geologist";

            case "ESTP":
                return "\n" + "\n" + "    Computer support technician\n" + "    Detectives\n" + "    Entrepreneur\n" +
                        "    Marketer\n" + "    Paramedic\n" + "    Police officer\n" + "    Sales agent";

            case "ESTJ":
                return "\n" + "\n" + "    Police officer\n" + "    Military\n" + "    Judge\n" + "    Politician\n" +
                        "    Teacher\n" + "    School administrator\n" + "    Business manager\n" + "    Accountant\n" + "    Banker";

            case "ESFP":
                return "\n" + "\n" + "    Artist\n" + "    Actor\n" + "    Counselor\n" + "    Social worker\n" + "    Athletic coach\n" +
                        "    Child care provider\n" + "    Musician\n" + "    Psychologist\n" + "    Human resources specialist\n" + "    Fashion designer";

            case "ESFJ":
                return "\n" + "\n" + "    Childcare\n" + "    Nursing\n" + "    Teaching\n" + "    Social work\n" +
                        "    Counseling\n" + "    Physician\n" + "    Receptionist\n" + "    Bookkeeper\n" + "    Office manager";

            case "ENFP":
                return "\n" + "\n" + "    Psychologist\n" + "    Journalist\n" + "    Actor\n" + "    TV Anchor/Reporter\n" +
                        "    Nutritionist\n" + "    Nurse\n" + "    Social Worker\n" + "    Politician\n" + "    Counselor";

            case "ENFJ":
                return "\n" + "\n" + "    Counselor\n" + "    Teacher\n" + "    Psychologist\n" +
                        "    Social worker\n" + "    Human resources manager\n" + "    Sales representative\n" + "    Manager";

            case "ENTP":
                return "\n" + "\n" + "    Engineer\n" + "    Lawyer\n" + "    Scientist\n" +
                        "    Psychologist\n" + "    Inventor\n" + "    Psychiatrist\n" + "    Journalist";

            default:
                return "\n" + "\n" + "    Human resources manager\n" + "    Company CEO or manager\n" + "    Lawyer\n" + "    Scientist\n" +
                        "    Software developer\n" + "    Business analyst\n" + "    Entrepreneur\n" + "    University professor";

        }


    }




}