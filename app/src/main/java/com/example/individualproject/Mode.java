package com.example.individualproject;

import java.io.Serializable;

public class Mode implements Serializable {
    int id;
    String name;
    MyColor color1, color2, color3;
    int temp1, temp2, temp3;

    public Mode(int id, String name,  MyColor color1, MyColor color2, MyColor color3, int temp1, int temp2, int temp3) {
        this.id = id;
        this.name = name;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
    }

    public String toBTString() {
        return temp1 + "\\n" + color1.r + "\\n" + color1.g + "\\n" + color1.b +
                "\\n" + temp2 + "\\n" + color2.r + "\\n" + color2.g + "\\n" + color2.b +
                "\\n" + temp3 + "\\n" + color3.r + "\\n" + color3.g + "\\n" + color3.b;
    }
}

