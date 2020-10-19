package com.example.thenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
        saveNoteButton.setImageResource(R.drawable.save);

        notesDatabaseHelper = new NotesDatabaseHelper(getApplicationContext());




            if(getIntent().hasExtra("EXTRA")) {
                Cursor cursor = notesDatabaseHelper.getCursor();
                int i = getIntent().getExtras().getInt("EXTRA") + 1;
                cursor.move(i);
                noteTitle.setText(cursor.getString(1));
                noteText.setText(cursor.getString(2));
                cursor.close();

            }




        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getIntent().hasExtra("EXTRA")){
                    notesDatabaseHelper.updateNote(getIntent().getExtras().getInt("EXTRA") + 1, noteTitle.getText().toString(),
                            noteText.getText().toString());

                } else {
                    notesDatabaseHelper.saveNote(noteTitle.getText().toString(), noteText.getText().toString());

                }

               Intent intent = new Intent(getApplicationContext(), NotelistActivity.class);
               startActivity(intent);
            }
        });

    }


}