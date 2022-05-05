package Breakout2;
import processing.core.PApplet;

import static java.lang.Math.sqrt;

public class Ball {
    //Attribute
    private int xBall;
    private int yBall;
    private final int width;
    private final PApplet myApplet;
    private int deltaY; //Geschwindigkeit in Y-Richtung
    private final Paddle myPaddle;
    private final Brick[] myBrick;
    private final int rBall;
    private int deltaX; //velocity in X

//Konstruktor

    public Ball(PApplet mA, Paddle p, Brick[] br, int x, int y, int b) {
        width = b;
        xBall = x;
        yBall = y;
        deltaX = 2;
        deltaY = 3;
        myApplet = mA;
        myPaddle = p;
        myBrick = br;
        rBall = width / 2;
    }

    //Methoden
    public void drawBall() {
        myApplet.fill(255, 0, 0);
        myApplet.circle(xBall, yBall, width);
    }

    public void moveBall() {
        xBall = xBall + deltaX;
        yBall = yBall + deltaY;
    }

    public void ballReflect() {
        if ((xBall + width / 2 > myApplet.width) || (xBall - width / 2 < 0)) {
            deltaX = -deltaX;
        }
        if ((yBall + width / 2 > myApplet.height) || (yBall - width / 2 < 0)) {
            deltaY = -deltaY;
        }
    }

    public void ballPaddleReflect() {
        if ((xBall + rBall > myPaddle.getPaddleX() - myPaddle.getWidth() / 2) &&
                (xBall - rBall < myPaddle.getPaddleX() + myPaddle.getWidth() / 2) &&
                (yBall + rBall > myPaddle.getPaddleY() - myPaddle.getHeight() / 2)) {
            deltaY = -deltaY;
        }
    }

    public void ballBrickReflect(int i) {
        int testX = xBall;
        int testY = yBall;
        int distX;
        int distY;
        double distance;
        boolean leftRight = false;
        boolean upDown = false;

        if (myBrick[i].getHit() == 0) {
            if (xBall < myBrick[i].getBrickX()) {
                testX = myBrick[i].getBrickX();
                leftRight = true;
            } else {
                if (xBall > myBrick[i].getBrickX() + myBrick[i].getBrickWidth()) {
                    testX = myBrick[i].getBrickX() + myBrick[i].getBrickWidth();
                    leftRight = true;
                }
            }

            if (yBall < myBrick[i].getBrickY()) {
                testY = myBrick[i].getBrickY();
                upDown = true;
            } else {
                if (yBall > myBrick[i].getBrickY() + myBrick[i].getBrickHeight()) {
                    testY = myBrick[i].getBrickY() + myBrick[i].getBrickHeight();
                    upDown = true;
                }
            }
            distX = xBall - testX;
            distY = yBall - testY;
            distance = sqrt((distX * distX) + (distY * distY));

            if (distance < width / 2) {
                if (upDown) {
                    deltaY = -deltaY;
                    myBrick[i].setHit(1);
                }
                if (leftRight) {
                    deltaX = -deltaX;
                    myBrick[i].setHit(1);
                }
            }
        }
    }
}
