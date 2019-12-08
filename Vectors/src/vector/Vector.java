package vector;

public class Vector {
	
	private double magnitude;
	private double angle;
	
	private double xComponent;
	private double yComponent;
	
	private Vector(double magnitude, double angle) {
		this.magnitude = magnitude;
		this.angle = angle;
		
		calcComponents();
	}
	
	private Vector(double xComponent, double yComponent, boolean isComponent) {
		this.xComponent = xComponent;
		this.yComponent = yComponent;
		
		calcMagnitudeAndAngle();
	}
	
	private void calcComponents() {
		xComponent = magnitude * Math.cos(angle);
		yComponent = magnitude * Math.sin(angle);
	}
	
	private void calcMagnitudeAndAngle() {
		angle = Math.atan(yComponent/xComponent);
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
	
	public static Vector createVectorWithComponents(double xComponent, double yComponent) {
		return new Vector(xComponent, yComponent, true);
	}
	
	public static Vector createVectorPolarForm(double magnitude, double angle) {
		return new Vector(magnitude, angle);
	}

}
