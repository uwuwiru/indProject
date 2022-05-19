package com.example.individualproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ModeAdapter extends ArrayAdapter<Mode> {

    public ModeAdapter(Context context, ArrayList<Mode> arr) {
        super(context, R.layout.mode_item, arr);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Mode mode = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mode_item, null);
        }

        ((TextView) convertView.findViewById(R.id.name_tv)).setText(mode.name);

        Button b_download, b_edit, b_delete;
        b_download = convertView.findViewById(R.id.download);
        b_edit = convertView.findViewById(R.id.edit);
        b_delete = convertView.findViewById(R.id.delete);

        b_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TO DO!!!
            }
        });

        b_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TO DO!!!
            }
        });

        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TO DO!!!
            }
        });

        return convertView;

    }

}
