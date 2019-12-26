package Car;

import java.awt.Color;
import java.awt.Point;

public class Car {

	Point topLeft;
	double angle; // in degrees
	double speed;
	Color color = Color.BLUE;

	public final int length = 100;
	public final int width = 40;
	public final double topSpeed = 1.0;

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

	public void moveCarForward(double acceleration, double time) {
		
		double distance = getDistance(speed, acceleration, time);
		topLeft.x += (int) (distance * Math.sin(angle));
		topLeft.y -= (int) (distance * Math.cos(angle));
		
		speed = speed + acceleration * time;
		
		if(speed >= topSpeed) {
			speed=topSpeed;
		}		

	}

}
