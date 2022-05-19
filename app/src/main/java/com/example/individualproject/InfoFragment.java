package com.example.individualproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class InfoFragment extends Fragment {


    boolean opened_flag_1 = false;
    boolean opened_flag_2 = false;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        TextView about_info_text;
        TextView rules_info_text;
        about_info_text = view.findViewById(R.id.about_info_textView);
        rules_info_text = view.findViewById(R.id.rules_info_textView);
        about_info_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

                if (!opened_flag_1) about_info_text.setMaxLines(Integer.MAX_VALUE);
                else about_info_text.setMaxLines(3);
                opened_flag_1 = !opened_flag_1;

            }
        });

        rules_info_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!opened_flag_2) rules_info_text.setMaxLines(Integer.MAX_VALUE);
                else rules_info_text.setMaxLines(3);
                opened_flag_2 = !opened_flag_2;
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


}