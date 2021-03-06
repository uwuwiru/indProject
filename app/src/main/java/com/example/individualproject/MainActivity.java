package com.example.individualproject;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import com.example.individualproject.R;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    public static ArrayList<Mode> modes;
    public static ArrayList<MyColor> start_colors;
    ImageButton show_adding_fragment_btn, show_modes_fragment_btn, show_info_fragment;
    static DB db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DB(this);
        show_info_fragment = findViewById(R.id.info_btn);
        show_modes_fragment_btn = findViewById(R.id.modes_btn);
        show_adding_fragment_btn = findViewById(R.id.add_btn);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, new AddingFragment());
        transaction.commit();

        modes = new ArrayList<>();
        start_colors = new ArrayList<>();

        MyColor color_red = new MyColor("Красный", 255, 0, 0);
        start_colors.add(color_red);
        MyColor color_green = new MyColor("Зелёный", 0, 255, 0);
        start_colors.add(color_green);
        MyColor color_blue = new MyColor("Синий", 0, 0, 255);
        start_colors.add(color_blue);
        MyColor color_purple = new MyColor("Фиолетовый", 255, 0, 255);
        start_colors.add(color_purple);
        MyColor color_cyan = new MyColor("Голубой", 0, 255, 255);
        start_colors.add(color_cyan);
        MyColor color_yellow = new MyColor("Желтый", 255, 255, 0);
        start_colors.add(color_yellow);

        //настроить старовые режимы

        modes.add(new Mode(-1, "Стандартный", color_blue, color_green, color_red, 15, 40, 65));
        modes.add(new Mode(-1,"Заварка зелёного чая", color_blue, color_green, color_red, 70, 78, 86));
        modes.add(new Mode(-1,"Детское питание", color_blue, color_green, color_red, 35, 36, 37));
    }

    public void show_adding_fragment(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, new AddingFragment());
        transaction.commit();
    }

    public void show_modes_fragment(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, new ModeFragment());
        transaction.commit();
    }

    public void show_info_fragment(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, new InfoFragment());
        transaction.commit();
    }
}