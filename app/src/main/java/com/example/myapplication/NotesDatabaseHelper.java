package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NotesDatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private String NAME;
    private String NOTE;

    public NotesDatabaseHelper(@Nullable Context context) {
        super(context, "DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE NOTES (_id INTEGER PRIMARY KEY, TEXT " + NAME +", TEXT " + NOTE + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NOTES");
        onCreate(sqLiteDatabase);
    }

    public void saveNote(String noteTitle, String noteText){
        db  = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, noteTitle);
        contentValues.put(NOTE, noteText);
        db.insert("NOTES", null, contentValues);
    }

    public void updateNote(int noteID, String noteTitle, String noteText){
        // to do method that updates notes
    }

    public Cursor getCursor(){
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM NOTES", null);
        return cursor;
    }
}
