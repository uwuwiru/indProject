package com.example.individualproject;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;

public class MyColor implements Serializable {
    String name;
    int r, g, b;

    public MyColor(String name, int r, int g, int b) {
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public static MyColor fromString(String s) {
        int r = 0, g = 0, b = 0;
        if (s.equals("Красный")){
            r=255;
            g=0;
            b=0;
        }

        if (s.equals("Зелёный")){
            r=0;
            g=255;
            b=0;
        }

        if (s.equals("Синий")){
            r=0;
            g=0;
            b=255;
        }

        if (s.equals("Фиолетовый")){
            r=255;
            g=0;
            b=255;
        }

        if (s.equals("Голубой")){
            r=0;
            g=255;
            b=255;
        }

        if (s.equals("Желтый")){
            r=255;
            g=255;
            b=0;
        }

        MyColor color = new MyColor(s, r, g, b);
        return color;
    }

    public static String myColor_to_dbString(MyColor color) {
        int colorR = color.getR();
        int colorG = color.getG();
        int colorB = color.getB();
        String dbString = colorR + " " + colorG + " " + colorB;
        return dbString;
    }
}


