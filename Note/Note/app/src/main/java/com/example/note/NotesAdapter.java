package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class NotesAdapter extends ArrayAdapter<String> {

    private Context context;
    private int resource;

    public NotesAdapter(Context context, int resource, ArrayList<String> notes) {
        super(context, resource, notes);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        String noteText = getItem(position);

        if (noteText != null) {
            TextView noteTextView = convertView.findViewById(R.id.noteTextView);
            noteTextView.setText(noteText);
        }

        return convertView;
    }
}
