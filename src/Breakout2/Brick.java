package Breakout2;

import processing.core.PApplet;

public class Brick {
//Attribute
    private int brickX;
    private int brickY;
    private int brickBreite;
    private int brickHoehe;
    private int getroffen;
    private int color;
    private PApplet meinApplet;
    private short gameModeNum;
private final static short DEFAULT_GAME = 0;
private final static short HIT_TWICE = 1;
//Konstruktor
    public Brick(PApplet ma, int xB, int yB, int breite, int hoehe){
        brickX = xB;
        brickY = yB;
        brickBreite = breite;
        brickHoehe = hoehe;
        getroffen = 0;
        color = 0xFF00FFFF;
        meinApplet = ma;
    }
    public Brick(PApplet ma, int xB, int yB, int breite, int hoehe, short gameMode){
        brickX = xB;
        brickY = yB;
        brickBreite = breite;
        brickHoehe = hoehe;
        getroffen = 0;
        color = 0xFF00FFFF;
        meinApplet = ma;
        String name = "NONE";
        switch(gameMode){
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
public static void gameNotification(){

}
public short getGameModeNum(){
        return gameModeNum;
}
//Methoden

    public void setGetroffen(int getroffen) {
        this.getroffen = getroffen;
    }

    public int getGetroffen() {
        return getroffen;
    }

    public void zeichenBrick(){
        if(getroffen == 0){
            meinApplet.rectMode(meinApplet.CORNER);
            meinApplet.fill(color);
            meinApplet.rect(brickX, brickY, brickBreite, brickHoehe);
        }

    }

    public int getBrickX() {
        return brickX;
    }

    public int getBrickY() {
        return brickY;
    }

    public int getBrickBreite() {
        return brickBreite;
    }

    public int getBrickHoehe() {
        return brickHoehe;
    }
}
