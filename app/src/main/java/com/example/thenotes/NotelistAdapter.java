package com.example.thenotes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
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
    boolean deleted = false;
    TextView noteView;

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
         noteView = (TextView) holder.itemView.findViewById(R.id.card_note_title);

         noteView.setText(notesList.get(position));
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(context, CreateNoteActivity.class);
                 intent.putExtra("EXTRA", position);
                 context.startActivity(intent);

             }
         });

         if(deleted == true){
             NotesDatabaseHelper n = new NotesDatabaseHelper(context);
             n.getWritableDatabase();
             n.deleteNote(position);
             n.close();

         }
         deleted = false;

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }




    class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        MenuItem item;
        CardView noteViewHolder;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteViewHolder = (CardView) itemView;

            itemView.setOnCreateContextMenuListener(this);

        }

        // Context Menu for Notelist

        @Override
        public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
               MenuItem delete = menu.add(0, noteView.getId(), Menu.NONE, "delete");
               delete.setOnMenuItemClickListener(onEditMenu);



        }
        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getGroupId()) {

                    case 0:

                        deleted = true;
                        Toast.makeText(context, "ok, the note deleted", Toast.LENGTH_SHORT).show();
                        Log.d("OnContextClick delete", "101");

                        break;
                }
                return true;
            }
        };

    }


    }

