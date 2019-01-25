package com.example.benja.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "APCS";
    private final Context dbContext;

    private static final String TABLE_NAME = "Quiz";
    private static final String TABLE_ID = "id";
    private static final String TABLE_SUBJECT = "Subject";
    private static final String TABLE_QUESTION = "Questions";
    private static final String TABLE_C1 = "C1";
    private static final String TABLE_C2 = "C2";
    private static final String TABLE_C3 = "C3";
    private static final String TABLE_C4 = "C4";
    private static final String TABLE_C5 = "C5";
    private static final String TABLE_CORRECT = "Correct";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
        dbContext = context;
        context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        InputStream is = dbContext.getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY, "
                + TABLE_SUBJECT + " TEXT, " + TABLE_QUESTION + " TEXT, " + TABLE_C1 + " TEXT, " + TABLE_C2 + " TEXT, "
                + TABLE_C3 + " TEXT, " + TABLE_C4 + " TEXT, " + TABLE_C5 + " TEXT, " + TABLE_CORRECT + " TEXT)";
        db.execSQL(CREATE_TABLE);

        //insert values
        String line = "";
        int count = 0;
        try{
            while((line = reader.readLine()) != null) {
                String[] questionsArr = line.split(",");
                ContentValues values = new ContentValues();
                values.put(TABLE_ID, count);
                values.put(TABLE_SUBJECT, questionsArr[0]);
                values.put(TABLE_QUESTION, questionsArr[1]);
                values.put(TABLE_C1, questionsArr[2]);
                values.put(TABLE_C2, questionsArr[3]);
                values.put(TABLE_C3, questionsArr[4]);
                values.put(TABLE_C4, questionsArr[5]);
                values.put(TABLE_C5, questionsArr[6]);
                values.put(TABLE_CORRECT, questionsArr[7]);
                db.insert(TABLE_NAME, null, values);
                count++;
            }
        }catch(Exception e){
            Log.d("ERROR", "" + e);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public String getTableName(){
        return TABLE_NAME;
    }
    public String getPrimaryKey(){
        return TABLE_ID;
    }
    public String getSubject(){
        return TABLE_SUBJECT;
    }

    public List<Question> getQuestions(int num){
        List<Question> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { TABLE_ID, TABLE_SUBJECT,
                        TABLE_QUESTION, TABLE_C1, TABLE_C2, TABLE_C3, TABLE_C4, TABLE_C5, TABLE_CORRECT}, TABLE_SUBJECT + "=?",
                new String[] { String.valueOf(num) }, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                Question aQuestion = new Question();
                aQuestion.setQuestion(cursor.getString(2));
                aQuestion.setChoices(cursor.getString(3));
                aQuestion.setChoices(cursor.getString(4));
                aQuestion.setChoices(cursor.getString(5));
                aQuestion.setChoices(cursor.getString(6));
                aQuestion.setChoices(cursor.getString(7));
                aQuestion.setCorrectChoice(cursor.getString(8));

                questionsList.add(aQuestion);
            } while(cursor.moveToNext());
        }
        cursor.close();
        return questionsList;
    }
}