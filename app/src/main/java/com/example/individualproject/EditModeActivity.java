package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EditModeActivity extends AppCompatActivity {

    Spinner colorSpin1, colorSpin2, colorSpin3;
    EditText etName, etTemp1, etTemp2, etTemp3;
    Mode extra_mode;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mode);
        extra_mode = (Mode) getIntent().getSerializableExtra("editable_mode");
        id = (int) getIntent().getSerializableExtra("id");//???
        colorSpin1 = findViewById(R.id.color1_spin);
        colorSpin2 = findViewById(R.id.color2_spin);
        colorSpin3 = findViewById(R.id.color3_spin);
        etName = findViewById(R.id.mode_name_et);
        etTemp1 = findViewById(R.id.temp1_et);
        etTemp2 = findViewById(R.id.temp2_et);
        etTemp3 = findViewById(R.id.temp3_et);
        String[] colorsArr = getResources().getStringArray(R.array.colorsNames);//?????

        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.colorsNames,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpin1.setAdapter(adapter);
        colorSpin2.setAdapter(adapter);
        colorSpin3.setAdapter(adapter);

        colorSpin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                colorSpin1.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        colorSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                colorSpin2.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        colorSpin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                colorSpin3.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        
        etName.setText(extra_mode.name);
        etTemp1.setText(extra_mode.temp1);
        etTemp2.setText(extra_mode.temp2);
        etTemp3.setText(extra_mode.temp3);
        colorSpin1.setSelection(MainActivity.start_colors.indexOf(extra_mode.color1));
        colorSpin2.setSelection(MainActivity.start_colors.indexOf(extra_mode.color2));
        colorSpin3.setSelection(MainActivity.start_colors.indexOf(extra_mode.color3));

        
    }

    public void editMode(View view) {
        MyColor color1 = MainActivity.start_colors.get((int) colorSpin1.getSelectedItemId());
        MyColor color2 = MainActivity.start_colors.get((int) colorSpin2.getSelectedItemId());
        MyColor color3 = MainActivity.start_colors.get((int) colorSpin3.getSelectedItemId());
        int temp1 = Integer.parseInt(String.valueOf(etTemp1.getText()));
        int temp2 = Integer.parseInt(String.valueOf(etTemp2.getText()));
        int temp3 = Integer.parseInt(String.valueOf(etTemp3.getText()));
        String name = etName.getText().toString();
        //какой айди у элемента в дб?
        MainActivity.db.update(id, name, MyColor.myColor_to_dbString(color1), MyColor.myColor_to_dbString(color2), MyColor.myColor_to_dbString(color3), temp1, temp2, temp3);
        Toast.makeText(this, "Успешно отредактировано!", Toast.LENGTH_SHORT).show();
        finish();
    }
}