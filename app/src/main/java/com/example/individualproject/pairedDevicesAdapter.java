package com.example.individualproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class pairedDevicesAdapter extends ArrayAdapter<MyBTDevice> {


    public Context context;


    public pairedDevicesAdapter(Context context, ArrayList<MyBTDevice> devicesArr) {
        super(context, R.layout.btdevice_item, devicesArr);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final MyBTDevice device = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.btdevice_item, null);
        }

        ((TextView) convertView.findViewById(R.id.name_tv)).setText(device.name);
        ((TextView) convertView.findViewById(R.id.address_tv)).setText(String.valueOf(device.address));



        return convertView;

    }
}
