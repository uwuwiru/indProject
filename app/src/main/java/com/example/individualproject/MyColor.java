package com.example.individualproject;

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

    public static int getIndex(MyColor color){
        String colorName = color.name;
        if (colorName.equals("Красный")) return 0;
        else if (colorName.equals("Зелёный")) return 1;
        else if (colorName.equals("Синий")) return 2;
        else if (colorName.equals("Фиолетовый")) return 3;
        else if (colorName.equals("Голубой")) return 4;
        else if (colorName.equals("Желтый")) return 5;
        else return -1;
    }

    public static String myColor_to_dbString(MyColor color) {
        return color.name;
    }
}


