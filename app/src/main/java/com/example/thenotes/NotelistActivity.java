package com.example.thenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotelistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    ArrayList<Note>list = new ArrayList<>();

    NotesDatabaseHelper notesDatabaseHelper;

    FloatingActionButton addNoteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notelist);
        addNoteButton = findViewById(R.id.button_add_note);
        notesDatabaseHelper = new NotesDatabaseHelper(this);

        addNoteButton.setImageResource(R.drawable.text);

        try {
            fillNotelist();
        }catch (RuntimeException r){
            Log.d("ERROR", "CAN'T FILL THE LIST");
        }

        addNote();

        recyclerView = findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotelistAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }


    public void addNote(){
        addNoteButton.setOnClickListener(new View.OnClickListener() {

            Intent intent = new Intent(getApplicationContext(), CreateNoteActivity.class);
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });
    }

    public void fillNotelist(){
        Cursor cursor = notesDatabaseHelper.getCursor();

        if(cursor!=null){
            cursor.moveToFirst();
            do{
                Note note = new Note();
                note.setTitle(cursor.getString(1));
                list.add(note);
            }while(cursor.moveToNext());

        }
        cursor.close();
        notesDatabaseHelper.close();

    }
}