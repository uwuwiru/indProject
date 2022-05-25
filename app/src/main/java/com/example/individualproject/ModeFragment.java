package com.example.individualproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


public class ModeFragment extends Fragment {

    ListView lv;
    Button new_mode_button;

    public ModeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mode, container, false);
        lv = (ListView) view.findViewById(R.id.list);
        new_mode_button = (Button) view.findViewById(R.id.button);
        ModeAdapter adapter = new ModeAdapter(getActivity().getApplicationContext(), makeModes());
        lv.setAdapter(adapter);
        new_mode_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), NewModeActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



    }
    ArrayList<Mode> makeModes() {
        ArrayList<Mode> modes_to_adapter = new ArrayList<>();
        modes_to_adapter.addAll(MainActivity.modes);
        modes_to_adapter.addAll(DB.selectAll());
        return modes_to_adapter;
    }


}