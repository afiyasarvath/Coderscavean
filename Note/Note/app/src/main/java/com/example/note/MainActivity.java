package com.example.note;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText noteEditText;
    private Button addNoteButton;
    private ListView notesListView;
    private ArrayList<String> notesList;
    private NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteEditText = findViewById(R.id.noteEditText);
        addNoteButton = findViewById(R.id.addNoteButton);
        notesListView = findViewById(R.id.notesListView);

        notesList = new ArrayList<>();
        notesAdapter = new NotesAdapter(this, R.layout.note, notesList);
        notesListView.setAdapter(notesAdapter);

        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteText = noteEditText.getText().toString();
                if (!noteText.isEmpty()) {
                    addNoteToList(noteText);
                    noteEditText.getText().clear();
                }
            }
        });
    }

    private void addNoteToList(String noteText) {
        notesList.add(noteText);
        notesAdapter.notifyDataSetChanged();
    }
}
