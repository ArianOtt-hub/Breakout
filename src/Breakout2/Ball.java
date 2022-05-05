package Breakout2;
import processing.core.PApplet;

import static java.lang.Math.sqrt;

public class Ball {
    //Attribute
    private int xBall;
    private int yBall;
    private int breite;
    private int deltaX; //Geschwindigkeit in x-Richtung
    private int deltaY; //Geschwindigkeit in Y-Richtung
    private PApplet myApplet;
    private Paddle myPaddle;
    private Brick[] myBrick;
    private int rBall;

//Konstruktor

    public Ball(PApplet mA, Paddle p, Brick[] br, int x, int y, int b) {
        breite = b;
        xBall = x;
        yBall = y;
        deltaX = 2;
        deltaY = 3;
        myApplet = mA;
        myPaddle = p;
        myBrick = br;
        rBall = breite / 2;
    }

    //Methoden
    public void ballZeichen() {
        myApplet.fill(255, 0, 0);
        myApplet.circle(xBall, yBall, breite);
    }

    public void ballBewegen() {
        xBall = xBall + deltaX;
        yBall = yBall + deltaY;
    }

    public void ballReflextieren() {
        if ((xBall + breite / 2 > myApplet.width) || (xBall - breite / 2 < 0)) {
            deltaX = -deltaX;
        }
        if ((yBall + breite / 2 > myApplet.height) || (yBall - breite / 2 < 0)) {
            deltaY = -deltaY;
        }
    }

    public void ballPaddleReflextieren() {
        if ((xBall + rBall > myPaddle.getPaddleX() - myPaddle.getBreite()/2) &&
                (xBall - rBall < myPaddle.getPaddleX() + myPaddle.getBreite()/2) &&
                (yBall + rBall > myPaddle.getPaddleY() - myPaddle.getHoehe()/2))
        {
            deltaY = -deltaY;
        }
    }

    public void ballBrickReflextieren(int i) {
        int testX = xBall;
        int testY = yBall;
        int distX;
        int distY;
        double distanz;
        boolean linksRechts = false;
        boolean obenUnten = false;

        if (myBrick[i].getGetroffen() == 0) {
            if (xBall < myBrick[i].getBrickX()) {
                testX = myBrick[i].getBrickX();
                linksRechts = true;
            } else {
                if (xBall > myBrick[i].getBrickX() + myBrick[i].getBrickBreite()) {
                    testX = myBrick[i].getBrickX() + myBrick[i].getBrickBreite();
                    linksRechts = true;
                }
            }

            if (yBall < myBrick[i].getBrickY()) {
                testY = myBrick[i].getBrickY();
                obenUnten = true;
            } else {
                if (yBall > myBrick[i].getBrickY() + myBrick[i].getBrickHoehe()) {
                    testY = myBrick[i].getBrickY() + myBrick[i].getBrickHoehe();
                    obenUnten = true;
                }
            }
            distX = xBall - testX;
            distY = yBall - testY;
            distanz = sqrt((distX * distX) + (distY * distY));

            if (distanz < breite / 2) {
                if (obenUnten) {
                    deltaY = -deltaY;
                    myBrick[i].setGetroffen(1);
                }
                if (linksRechts) {
                    deltaX = -deltaX;
                    myBrick[i].setGetroffen(1);
                }
            }
        }
    }
}