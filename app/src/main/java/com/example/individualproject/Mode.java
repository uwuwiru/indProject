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

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyColor getColor1() {
        return color1;
    }

    public void setColor1(MyColor color1) {
        this.color1 = color1;
    }

    public MyColor getColor2() {
        return color2;
    }

    public void setColor2(MyColor color2) {
        this.color2 = color2;
    }

    public MyColor getColor3() {
        return color3;
    }

    public void setColor3(MyColor color3) {
        this.color3 = color3;
    }

    public int getTemp1() {
        return temp1;
    }

    public void setTemp1(int temp1) {
        this.temp1 = temp1;
    }

    public int getTemp2() {
        return temp2;
    }

    public void setTemp2(int temp2) {
        this.temp2 = temp2;
    }

    public int getTemp3() {
        return temp3;
    }

    public void setTemp3(int temp3) {
        this.temp3 = temp3;
    }

    public String toBTString() {
        return temp1 + "\\n" + color1.r + "\\n" + color1.g + "\\n" + color1.b +
                "\\n" + temp2 + "\\n" + color2.r + "\\n" + color2.g + "\\n" + color2.b +
                "\\n" + temp3 + "\\n" + color3.r + "\\n" + color3.g + "\\n" + color3.b;
    }
}

