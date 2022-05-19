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
    static Context context;

    public ModeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        View view = inflater.inflate(R.layout.fragment_mode, container, false);
        lv = (ListView) getView().findViewById(R.id.list);
        new_mode_button = (Button) getView().findViewById(R.id.button);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ModeAdapter adapter = new ModeAdapter(context, makeModes());//контекст?
        //проверка git
        lv.setAdapter(adapter);
        new_mode_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), NewModeActivity.class);
                startActivity(i);
                adapter.notifyDataSetChanged();
            }
        });

    }
    ArrayList<Mode> makeModes() {
        ArrayList<Mode> modes_to_adapter = new ArrayList<>();
        for (Mode m: MainActivity.modes){
            modes_to_adapter.add(m);
        }
        ArrayList<Mode> modes_from_db = new ArrayList<>();
        Collections.copy(modes_from_db, DB.selectAll());
        for (Mode m: modes_from_db){
            modes_to_adapter.add(m);
        }
        return modes_to_adapter;
    }


}