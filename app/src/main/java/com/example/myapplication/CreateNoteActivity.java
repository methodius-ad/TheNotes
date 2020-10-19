package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateNoteActivity extends AppCompatActivity {
    EditText noteTitle;
    EditText noteText;
    FloatingActionButton saveNoteButton;

    NotesDatabaseHelper notesDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        noteTitle = (EditText)findViewById(R.id.note_title);
        noteText = (EditText)findViewById(R.id.note_text);
        saveNoteButton = (FloatingActionButton)findViewById(R.id.button_save_note);

        notesDatabaseHelper = new NotesDatabaseHelper(getApplicationContext());

        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesDatabaseHelper.saveNote(noteTitle.getText().toString(), noteText.getText().toString());
            }
        });
        //create database and make saving notes to click the button

    }
}