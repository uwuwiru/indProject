package com.example.individualproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class InfoFragment extends Fragment {


    boolean opened_flag_about = false;
    boolean opened_flag_toAdd = false;
    boolean opened_flag_toMode = false;
    boolean opened_flag_rules = false;
    boolean opened_flag_toAsk = false;
    boolean opened_flag_toDL = false;

    TextView about_info_tv, how_to_add_tv, how_to_mode_tv, rules_info_tv, how_to_ask_tv, how_to_download_tv;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        about_info_tv = view.findViewById(R.id.about_info_textView);
        how_to_add_tv = view.findViewById(R.id.howToAdd_info_textView);
        how_to_download_tv = view.findViewById(R.id.howToDownload_info_textView);
        how_to_mode_tv = view.findViewById(R.id.howToMode_info_textView);
        rules_info_tv = view.findViewById(R.id.rules_info_textView);
        how_to_ask_tv = view.findViewById(R.id.howToAsk_info_textView);

        about_info_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!opened_flag_about) about_info_tv.setMaxLines(Integer.MAX_VALUE);
                else about_info_tv.setMaxLines(3);
                opened_flag_about = !opened_flag_about;
            }
        });

        how_to_add_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!opened_flag_toAdd) how_to_add_tv.setMaxLines(Integer.MAX_VALUE);
                else how_to_add_tv.setMaxLines(3);
                opened_flag_toAdd = !opened_flag_toAdd;
            }
        });
        how_to_download_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!opened_flag_toDL) how_to_download_tv.setMaxLines(Integer.MAX_VALUE);
                else how_to_download_tv.setMaxLines(3);
                opened_flag_toDL = !opened_flag_toDL;
            }
        });
        how_to_mode_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!opened_flag_toMode) how_to_mode_tv.setMaxLines(Integer.MAX_VALUE);
                else how_to_mode_tv.setMaxLines(3);
                opened_flag_toMode = !opened_flag_toMode;
            }
        });
        rules_info_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!opened_flag_rules) rules_info_tv.setMaxLines(Integer.MAX_VALUE);
                else rules_info_tv.setMaxLines(3);
                opened_flag_rules = !opened_flag_rules;
            }
        });
        how_to_ask_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!opened_flag_toAsk) how_to_ask_tv.setMaxLines(Integer.MAX_VALUE);
                else how_to_ask_tv.setMaxLines(3);
                opened_flag_toAsk = !opened_flag_toAsk;
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}