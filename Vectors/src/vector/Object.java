package vector;

import java.awt.Point;
import java.util.ArrayList;

public class Object {
	
	Point position;

	boolean isOnSurface;

	ArrayList<Force> forcesOnObject = new ArrayList<Force>();

	double mass;
	double volume;

	double topSpeed;

	public Object() {
	}

	public boolean isOnSurface() {
		return isOnSurface;
	}

	public void setOnSurface(boolean isOnSurface) {
		this.isOnSurface = isOnSurface;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	public void addForce(Force force) {
		forcesOnObject.add(force);
	}

	public void setNormalAndWeight() {

		Force normal = Force.createForcePolarForm(mass * NumberConstants.ACCELERATION_DUE_TO_GRAVITY.value, 90);
		Force weight = Force.createForcePolarForm(mass * NumberConstants.ACCELERATION_DUE_TO_GRAVITY.value, 270);

		forcesOnObject.add(weight);
		forcesOnObject.add(normal);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	

}
