package vector;

import java.util.ArrayList;

public class Vector {

	private double magnitude;
	private double angle;

	private double xComponent;
	private double yComponent;

	private int startX;
	private int startY;

	protected Vector(double magnitude, double angle) {
		this.magnitude = magnitude;
		this.angle = angle;

		calcComponents();
	}

	protected Vector(double magnitude, double angle, int startX, int startY) {
		this.magnitude = magnitude;
		this.angle = angle;

		this.startX = startX;
		this.startY = startY;

		calcComponents();
	}

	protected Vector(double xComponent, double yComponent, boolean isComponent) {
		this.xComponent = xComponent;
		this.yComponent = yComponent;

		calcMagnitudeAndAngle();
	}

	protected Vector(int startX, int startY, double xComponent, double yComponent, boolean isComponent) {
		this.xComponent = xComponent;
		this.yComponent = yComponent;

		this.startX = startX;
		this.startY = startY;

		calcMagnitudeAndAngle();
	}

	private void calcComponents() {
		xComponent = magnitude * Math.cos(angle);
		yComponent = magnitude * Math.sin(angle);
	}

	private void calcMagnitudeAndAngle() {
		angle = Math.atan(yComponent / xComponent);
		magnitude = Math.sqrt(xComponent * xComponent + yComponent * yComponent);
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getxComponent() {
		return xComponent;
	}

	public void setxComponent(double xComponent) {
		this.xComponent = xComponent;
	}

	public double getyComponent() {
		return yComponent;
	}

	public void setyComponent(double yComponent) {
		this.yComponent = yComponent;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public static Vector createVectorWithComponents(int startX, int startY, double xComponent, double yComponent) {
		return new Vector(startX, startY, xComponent, yComponent, true);
	}

	public static Vector createVectorWithComponents(double xComponent, double yComponent) {
		return new Vector(xComponent, yComponent, true);
	}

	public static Vector createVectorPolarForm(double magnitude, double angle, int startX, int startY) {
		return new Vector(magnitude, angle, startX, startY);
	}

	public static Vector createVectorPolarForm(double magnitude, double angle) {
		return new Vector(magnitude, angle);
	}

	public static Vector addVectors(Vector v1, Vector v2) {
		return new Vector(v1.startX, v1.startY, v1.xComponent + v2.xComponent, v1.yComponent + v2.yComponent, true);
	}

	public static Vector addVectors(Vector[] arr) {
		double xComponent = 0;
		double yComponent = 0;

		for (Vector vector : arr) {
			xComponent += vector.xComponent;
			yComponent += vector.yComponent;
		}

		return new Vector(arr[0].startX, arr[0].startY, xComponent, yComponent, true);
	}

	public static Vector addVectors(ArrayList<Vector> arr) {
		double xComponent = 0;
		double yComponent = 0;

		for (Vector vector : arr) {
			xComponent += vector.xComponent;
			yComponent += vector.yComponent;
		}

		return new Vector(arr.get(0).startX, arr.get(0).startY, xComponent, yComponent, true);
	}

}
