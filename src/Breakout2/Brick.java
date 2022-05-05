package Breakout2;

import processing.core.PApplet;

public class Brick {
    private final static short DEFAULT_GAME = 0;
    private final static short HIT_TWICE = 1;
    //Attribute
    private final int brickX;
    private final int brickY;
    private final int brickWidth;
    private final int brickHeight;
    private final int colour;
    private short gameModeNum;
    private final PApplet meinApplet;
    private int hit;

    //Konstruktor
    public Brick(PApplet ma, int xB, int yB, int breite, int hoehe) {
        brickX = xB;
        brickY = yB;
        brickWidth = breite;
        brickHeight = hoehe;
        hit = 0;
        colour = 0xFF00FFFF;
        meinApplet = ma;
    }

    public Brick(PApplet ma, int xB, int yB, int breite, int hoehe, short gameMode) {
        brickX = xB;
        brickY = yB;
        brickWidth = breite;
        brickHeight = hoehe;
        hit = 0;
        colour = 0xFF00FFFF;
        meinApplet = ma;
        String name = "NONE";
        switch (gameMode) {
            case DEFAULT_GAME:
                name = "DEFAULT_GAME";
                gameModeNum = gameMode;
            case HIT_TWICE:
                name = "HIT_TWICE";
                gameModeNum = gameMode;
            default:
                System.out.println(name + " is chosen");
                break;
        }
    }

    public static void gameNotification() {

    }

    public short getGameModeNum() {
        return gameModeNum;
    }
//Methoden

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void drawBrick() {
        if (hit == 0) {
            meinApplet.rectMode(meinApplet.CORNER);
            meinApplet.fill(colour);
            meinApplet.rect(brickX, brickY, brickWidth, brickHeight);
        }

    }

    public int getBrickX() {
        return brickX;
    }

    public int getBrickY() {
        return brickY;
    }

    public int getBrickWidth() {
        return brickWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }
}
