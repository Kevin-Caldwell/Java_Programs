package Car;

import java.awt.Color;
import java.awt.Point;

public class Car {

	Point topLeft;

	double angle; // in rad
	double speed;
	double acceleration;

	Color color = Color.BLUE;

	public final int length = 100;
	public final int width = 40;
	public final double topSpeed = 1.0;

	public final int startX = 300;
	public final int startY = 300;

	public final double startSpeed = 0.0;
	public final double startAngle = 0.0;
	public final double MAX_ACCELERATION = 0.20;

	public Car() {
		this.topLeft = new Point(startX, startY);
		this.angle = startAngle;
		this.speed = startSpeed;
	}

	public Car(int x, int y, double speed, double angle) {
		this.topLeft = new Point(x, y);
		this.angle = angle;
		this.speed = speed;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}

	public int getX() {
		return topLeft.x;
	}

	public int getY() {
		return topLeft.y;
	}

	public void setX(int x) {
		topLeft.x = x;
	}

	public void setY(int y) {
		topLeft.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDistance(double speed, double acceleration, double time) {
		return speed * time + 0.5 * acceleration * time * time;
	}

	public void moveCar(double time) {
		double distance = getDistance(speed, acceleration, time);

		topLeft.x += (distance * Math.sin(angle));
		topLeft.y -= (distance * Math.cos(angle));

		speed += acceleration * time;

		if(speed > 0) {
			if (speed >= topSpeed) {
				speed = topSpeed;
				acceleration = 0;
			}
		} else {
			if (speed <= topSpeed) {
				speed = -1* topSpeed;
				acceleration = 0;
			}
		}

	}

	public void slowToStop(double time) {
		speed = 0;
		acceleration = 0;
//		if(speed != 0) {
//			if(acceleration != 0) {
//				acceleration *= -1;				
//			} else {
//				if(speed < 0) {
//					acceleration = MAX_ACCELERATION;
//				} else {
//					acceleration = -1 * MAX_ACCELERATION;
//				}
//			}
//			System.out.println("slowing down");
//			moveCar(time);
//		}		
	}
}
