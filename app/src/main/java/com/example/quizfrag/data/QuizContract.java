package com.example.quizfrag.data;

import android.provider.BaseColumns;

/**
 * Created by delaroy on 11/30/17.
 */

public class QuizContract {

    public static class MovieEntry implements BaseColumns {
        public static final String TABLE_MIND = "tmind";
        public static final String KEY_MID = "mid";
        public static final String KEY_MQUES = "mquestion";



        public static final String TABLE_ENERGY = "tenergy";
        public static final String KEY_EID = "eid";
        public static final String KEY_EQUES = "equestion";


        public static final String TABLE_NATURE = "tnature";
        public static final String KEY_NID = "nid";
        public static final String KEY_NQUES = "nquestion";


        public static final String TABLE_TACTICS = "ttactics";
        public static final String KEY_TID = "tid";
        public static final String KEY_TQUES = "tquestion";



    }
}
