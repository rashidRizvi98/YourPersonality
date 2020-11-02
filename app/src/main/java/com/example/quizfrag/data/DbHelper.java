package com.example.quizfrag.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quizfrag.Question;

import java.util.ArrayList;
import java.util.List;

import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_EID;
import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_EQUES;
import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_MID;
import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_MQUES;
import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_NID;
import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_NQUES;
import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_TID;
import static com.example.quizfrag.data.QuizContract.MovieEntry.KEY_TQUES;
import static com.example.quizfrag.data.QuizContract.MovieEntry.TABLE_ENERGY;
import static com.example.quizfrag.data.QuizContract.MovieEntry.TABLE_MIND;
import static com.example.quizfrag.data.QuizContract.MovieEntry.TABLE_NATURE;
import static com.example.quizfrag.data.QuizContract.MovieEntry.TABLE_TACTICS;


public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "YourPersonality";
	// tasks table name

	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String msql = "CREATE TABLE IF NOT EXISTS " + TABLE_MIND + " ( "
				+ KEY_MID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_MQUES + " TEXT)";
		db.execSQL(msql);

		String esql = "CREATE TABLE IF NOT EXISTS " + TABLE_ENERGY + " ( "
				+ KEY_EID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_EQUES + " TEXT)";
		db.execSQL(esql);


		String nsql = "CREATE TABLE IF NOT EXISTS " + TABLE_NATURE + " ( "
				+ KEY_NID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_NQUES + " TEXT)";
		db.execSQL(nsql);


		String tsql = "CREATE TABLE IF NOT EXISTS " + TABLE_TACTICS + " ( "
				+ KEY_TID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_TQUES + " TEXT)";
		db.execSQL(tsql);



		addMindQuestions();
		addEnergyQuestions();
		addNatureQuestions();
		addTacticsQuestions();

	}
	private void addMindQuestions() {
		Question m1 = new Question("1.You feel less energized after spending time with a group of people.");
		this.addMindQuestion(m1);
		Question m2 = new Question("2.If someone does not respond to your e-mail quickly, you start wondering if you said something wrong.");
		this.addMindQuestion(m2);
		Question m3 = new Question("3.If the room is full, you stay closer to the walls, avoiding the center.");
		this.addMindQuestion(m3);
		Question m4=new Question("4.You feel very anxious in a stressful situation.");
		this.addMindQuestion(m4);
		Question m5=new Question("5.You do not usually initiate conversations.");
		this.addMindQuestion(m5);

	}
	private void addEnergyQuestions() {
		Question e1 = new Question("6.You stick to the traditional way of performing common tasks.");
		this.addEnergyQuestion(e1);
		Question e2 = new Question("7.You find it easy to stay to stay relaxed even when there is some pressure.");
		this.addEnergyQuestion(e2);
		Question e3 = new Question("8.You do not care for people who make themselves the center of attention.");
		this.addEnergyQuestion(e3);
		Question e4=new Question("9.Generally speaking, you rely  more on your experience than your imagination.");
		this.addEnergyQuestion(e4);
		Question e5=new Question("10.You often contemplate the reasons for human existence.");
		this.addEnergyQuestion(e5);

	}
	private void addNatureQuestions() {
		Question n1 = new Question("11.It is often difficult for you to relate to other people's feelings.");
		this.addNatureQuestion(n1);
		Question n2 = new Question("12.You see yourself as very emotionally stable.");
		this.addNatureQuestion(n2);
		Question n3 = new Question("13.Winning a debate matters less to you than making sure no on gets upset.");
		this.addNatureQuestion(n3);
		Question n4=new Question("14.Your mood can change very quickly.");
		this.addNatureQuestion(n4);
		Question n5=new Question("15.You are more likely to offer emotional support than suggest ways to deal with the problem.");
		this.addNatureQuestion(n5);

	}
	private void addTacticsQuestions() {
		Question t1 = new Question("16.When you take a trip, you prefer to just go without making a schedule.");
		this.addTacticsQuestion(t1);
		Question t2 = new Question("17.You are more of a natural improviser than a careful planner.");
		this.addTacticsQuestion(t2);
		Question t3 = new Question("18.You frequently misplace your things.");
		this.addTacticsQuestion(t3);
		Question t4 = new Question("19.You would rather improvise than spend time coming up with a detailed plan.");
		this.addTacticsQuestion(t4);
		Question t5 = new Question("20.The idea of making a to-do list for the weekend stresses you out.");
		this.addTacticsQuestion(t5);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MIND);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENERGY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NATURE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TACTICS);

		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addMindQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_MQUES, quest.getQUESTION());


		// Inserting Row
		dbase.insert(TABLE_MIND, null, values);

	}

	public void addEnergyQuestion(Question questE) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_EQUES, questE.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_ENERGY, null, values);

	}

	public void addNatureQuestion(Question questN) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NQUES, questN.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_NATURE, null, values);

	}

		public void addTacticsQuestion(Question questT) {
			//SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(KEY_TQUES, questT.getQUESTION());
			// Inserting Row
			dbase.insert(TABLE_TACTICS, null, values);

		}




		public List<Question> getAllMindQuestions() {
		List<Question> mindQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_MIND;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question mindq = new Question();
				mindq.setID(cursor.getInt(0));
				mindq.setQUESTION(cursor.getString(1));

				mindQList.add(mindq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return mindQList;
	}


	public List<Question> getAllEnergyQuestions() {
		List<Question> energyQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_ENERGY;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question energyq = new Question();
				energyq.setID(cursor.getInt(0));
				energyq.setQUESTION(cursor.getString(1));
				energyQList.add(energyq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return energyQList;
	}


	public List<Question> getAllNatureQuestions() {
		List<Question> natureQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_NATURE;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question natureq = new Question();
				natureq.setID(cursor.getInt(0));
				natureq.setQUESTION(cursor.getString(1));
				natureQList.add(natureq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return natureQList;
	}


	public List<Question> getAllTacticsQuestions() {
		List<Question> tacticsQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TACTICS;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question tacticsq = new Question();
				tacticsq.setID(cursor.getInt(0));
				tacticsq.setQUESTION(cursor.getString(1));
				tacticsQList.add(tacticsq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return tacticsQList;
	}




}
