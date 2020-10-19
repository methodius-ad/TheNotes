package com.example.thenotes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class NotelistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String> notesList;
    Context context;

    NotelistAdapter(ArrayList<String>list, Context context){
      notesList = list;
      this.context = context;
     // notesList.add("ijk");

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(view);

        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final TextView noteView = (TextView) holder.itemView.findViewById(R.id.card_note_title);
         noteView.setText(notesList.get(position));
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(context, CreateNoteActivity.class);
                 intent.putExtra("EXTRA", position);
                 context.startActivity(intent);

             }
         });

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }


    class NoteViewHolder extends RecyclerView.ViewHolder {
        CardView noteViewHolder;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteViewHolder = (CardView) itemView;

        }


    }


    }

