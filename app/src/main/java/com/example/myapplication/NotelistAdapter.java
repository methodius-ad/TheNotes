package com.example.myapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotelistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String> notesList;

    NotelistAdapter(ArrayList<String>notesLis){
      notesList = this.notesList;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(view);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView noteView = (TextView) holder.itemView.findViewById(R.id.card_note_title);
         noteView.setText(notesList.get(position));
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

