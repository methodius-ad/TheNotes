package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotelistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    ArrayList<String>list = new ArrayList<>();


    FloatingActionButton addNoteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notelist);

        addNoteButton = (FloatingActionButton)findViewById(R.id.button_add_note);

        list.add("fsffes");
        addNote();

       recyclerView = findViewById(R.id.rec);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       adapter = new NotelistAdapter(list);
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
}