package Breakout2;
import processing.core.PApplet;

public class Main extends PApplet {
	Ball myBall;
	Paddle myPaddle;
	Brick[] myBrick = new Brick[20];

	public static void main(String[] args) {
		PApplet.main("Breakout2.Main");
	}

	public void settings(){
		size(600, 600);
	}

	public void setup() {
		int a = 0;
		int x= 10;
		int y = 50;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				myBrick[a] = new Brick(this, x ,y, 100,20, (short) 1);
				a++;
				x += 120;
			}
			x = 10;
			y += 30;
		}

		myPaddle = new Paddle(this, 200);
		//myBrick =
		myBall = new Ball(this, myPaddle, myBrick,100, 100,20);

		rectMode(CENTER);
		ellipseMode(CENTER);
	}

	public void draw() {
		background(100,200,140);
		myBall.ballZeichen();
		myBall.ballBewegen();
		myBall.ballReflextieren();
		myPaddle.paddleZeichen();
		myPaddle.paddleBewegen();
		myBall.ballPaddleReflextieren();
		for (int i = 0; i < myBrick.length; i++) {
			myBrick[i].zeichenBrick();
			myBall.ballBrickReflextieren(i);
		}



	}
}

