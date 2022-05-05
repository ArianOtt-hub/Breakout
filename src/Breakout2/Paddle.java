package Breakout2;

import processing.core.PApplet;

public class Paddle {
    //Attribute
    private final int width;
    private final int height;
    private int paddleX;
    private final int paddleY;
    private final PApplet myApplet;


    //Konstruktor
    public Paddle(PApplet mA, int b) {
        myApplet = mA;
        width = b;
        height = 20;
        paddleX = myApplet.width / 2;
        paddleY = myApplet.height - 30;
    }

//Methoden

    public void paddleDraw() {
        myApplet.rectMode(myApplet.CENTER);
        myApplet.fill(255, 255, 0);
        myApplet.rect(paddleX, paddleY, width, height);
    }

    public void paddleMove() {
        paddleX = myApplet.mouseX;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY() {
        return paddleY;
    }
}
