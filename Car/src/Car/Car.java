package Car;

import java.awt.Color;
import java.awt.Point;

public class Car {

	double topLeft_X;
	double topLeft_Y;
	

	double angle; // in rad
	double speed;
	double acceleration;

	Color color = Color.BLUE;

	public final static int length = 100;
	public final static int width = 40;
	public final double topSpeed = 100;

	public final int startX = Main.currLevel.startPosition.x + (int)((Main.currLevel.startPosition.height - length) * 0.5);
	public final int startY = Main.currLevel.startPosition.y + (int)((Main.currLevel.startPosition.width - width) * 0.5);

	public final double startSpeed = 0.0;
	public final double startAngle = 0.0;
	public final double MAX_ACCELERATION = 40;
	public final double slow_factor = 10;

	public Car() {
		topLeft_X = startX;
		topLeft_Y = startY;
		this.angle = startAngle;
		this.speed = startSpeed;
	}

	public Car(int x, int y, double speed, double angle) {
		this.topLeft_X = x;
		this.topLeft_Y = y;
		this.angle = angle;
		this.speed = speed;
	}

	public Point getTopLeft() {
		return new Point((int)topLeft_X, (int)topLeft_Y);
	}

	public double getDistance(double speed, double acceleration, double time) {
		return speed * time + 0.5 * acceleration * time * time;
	}

	public void moveCar(double time) {
		double distance = getDistance(speed, acceleration, time);

		topLeft_X += (distance * Math.sin(angle));
		topLeft_Y -= (distance * Math.cos(angle));

		speed += acceleration * time;

		if(speed > 0) {
			if (speed >= topSpeed) {
				speed = topSpeed;
				acceleration = 0;
			}
		} else if(speed < 0){
			if (-1 * speed >= topSpeed) {
				speed = -1 * topSpeed;
				acceleration = 0;
			}
		}

	}
	
	public int round(double speed) {
		int num = (int)speed;
		
		if(num % 10 < 5) {
			return num - num % 10;
		} else {
			return num - 10 + num % 10;
		}
	}

	public void slowToStop(double time) {
		if(round(speed) != 0) {
			if(acceleration  != 0) {
				if(speed < 0) {
					acceleration += slow_factor;
				} else if(speed > 0){
					acceleration -= slow_factor;
				}
			} else {
				if(speed < 0) {
					acceleration += slow_factor;
				} else if(speed > 0){
					acceleration -= slow_factor;
				}
			}
		} else {
			speed = 0;
			if(acceleration != 0) {
				acceleration = 0;
			}
		}
		
		moveCar(time);
	
	}
}
