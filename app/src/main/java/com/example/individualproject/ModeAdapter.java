package com.example.individualproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ModeAdapter extends ArrayAdapter<Mode> {

    public Context context;

    public ModeAdapter(Context context, ArrayList<Mode> arr) {
        super(context, R.layout.mode_item, arr);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Mode mode = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mode_item, null);
        }

        ((TextView) convertView.findViewById(R.id.name_tv)).setText(mode.name);

        ImageButton b_download, b_edit, b_delete;
        b_download = convertView.findViewById(R.id.download);
        b_edit = convertView.findViewById(R.id.edit);
        b_delete = convertView.findViewById(R.id.delete);

        b_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AddingFragment.selectedDevice!=null && AddingFragment.clientSocket!=null) {
                    try {
                        //Получаем выходной поток для передачи данных
                        OutputStream outStream = AddingFragment.clientSocket.getOutputStream();
                        byte[] message = mode.toString().getBytes(StandardCharsets.UTF_8);
                        outStream.write(message);
                        Toast.makeText(parent.getContext(), "Успешно загружено на устройство", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        Toast.makeText(parent.getContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(parent.getContext(), "Соединитесь с устройством", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position>=3){
                Intent i = new Intent(context, EditModeActivity.class);//контекст?????
                i.putExtra("editable_mode", mode);
                i.putExtra("id", position-3);
                context.startActivity(i);
                }

            }
        });

        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position>=3){
                    MainActivity.db.delete(mode.name);
                    Toast.makeText(parent.getContext(), "Успешно удалено!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return convertView;

    }

}
