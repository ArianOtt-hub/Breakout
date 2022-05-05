package Breakout2;

import processing.core.PApplet;

public class Paddle {
//Attribute
    private int breite;
    private int hoehe;
    private int paddleX;
    private int paddleY;
    private PApplet myApplet;



    //Konstruktor
    public Paddle(PApplet mA,int b){
        myApplet = mA;
        breite = b;
        hoehe = 20;
        paddleX = myApplet.width/2;
        paddleY = myApplet.height-30;
    }

//Methoden

    public void paddleZeichen(){
        myApplet.rectMode(myApplet.CENTER);
        myApplet.fill(255, 255, 0);
        myApplet.rect(paddleX,paddleY, breite, hoehe);
    }

    public void paddleBewegen(){
        paddleX = myApplet.mouseX;
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY() {
        return paddleY;
    }
}
