package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditModeActivity extends AppCompatActivity {

    Spinner colorSpin1, colorSpin2, colorSpin3;
    EditText etName, etTemp1, etTemp2, etTemp3;
    Mode extra_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mode);
        extra_mode = (Mode) getIntent().getSerializableExtra("editable_mode");
        colorSpin1 = findViewById(R.id.color1_spin);
        colorSpin2 = findViewById(R.id.color2_spin);
        colorSpin3 = findViewById(R.id.color3_spin);
        etName = findViewById(R.id.mode_name_et);
        etTemp1 = findViewById(R.id.temp1_et);
        etTemp2 = findViewById(R.id.temp2_et);
        etTemp3 = findViewById(R.id.temp3_et);

        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.colorsNames,
                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpin1.setAdapter(adapter);
        colorSpin2.setAdapter(adapter);
        colorSpin3.setAdapter(adapter);

        etName.setText(extra_mode.name);
        etTemp1.setText(extra_mode.temp1 + "");
        etTemp2.setText(extra_mode.temp2 + "");
        etTemp3.setText(extra_mode.temp3 + "");
        colorSpin1.setSelection(MyColor.getIndex(extra_mode.color1));
        colorSpin2.setSelection(MyColor.getIndex(extra_mode.color2));
        colorSpin3.setSelection(MyColor.getIndex(extra_mode.color3));

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
    }

    public void editMode(View view) {
        if (etTemp1.getText().toString().equals("") || etTemp2.getText().toString().equals("") || etTemp3.getText().toString().equals("") || etName.getText().toString().equals(""))
            Toast.makeText(this, "Данные введены некорректно", Toast.LENGTH_SHORT).show();
        else {
            MyColor color1 = MainActivity.start_colors.get(colorSpin1.getSelectedItemPosition());
            MyColor color2 = MainActivity.start_colors.get(colorSpin2.getSelectedItemPosition());
            MyColor color3 = MainActivity.start_colors.get(colorSpin3.getSelectedItemPosition());
            int temp1 = Integer.parseInt(String.valueOf(etTemp1.getText()));
            int temp2 = Integer.parseInt(String.valueOf(etTemp2.getText()));
            int temp3 = Integer.parseInt(String.valueOf(etTemp3.getText()));
            if (temp1 < temp2 && temp2 < temp3) {
                String name = etName.getText().toString();
                MainActivity.db.update(extra_mode.id, name, MyColor.myColor_to_dbString(color1), MyColor.myColor_to_dbString(color2), MyColor.myColor_to_dbString(color3), temp1, temp2, temp3);
                Toast.makeText(this, "Успешно отредактировано!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Данные введены некорректно", Toast.LENGTH_SHORT).show();
            }
        }
    }
}