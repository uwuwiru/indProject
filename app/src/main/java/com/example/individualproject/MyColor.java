package com.example.individualproject;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class MyColor {
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
        String r = null, g = null, b = null;
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        int count = 1;
        for (char c : chars) {
            if (c == ' ') {
                count++;
                continue;
            }
            switch (count) {
                case 1:
                    r += String.valueOf(c);
                    break;
                case 2:
                    g += String.valueOf(c);
                    break;

                case 3:
                    b += String.valueOf(c);
                    break;
            }
        }
        MyColor color = new MyColor(s, Integer.parseInt(r), Integer.parseInt(g), Integer.parseInt(b));
        return color;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Color toLayoutColor(MyColor myColor) {
        Color c = Color.valueOf(myColor.getR(), myColor.getG(), myColor.getB());
        return c;
    }

    public static String myColor_to_dbString(MyColor color) {
        int colorR = color.getR();
        int colorG = color.getG();
        int colorB = color.getB();
        String dbString = colorR + " " + colorG + " " + colorB;
        return dbString;
    }
}


