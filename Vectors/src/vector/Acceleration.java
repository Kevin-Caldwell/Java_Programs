package vector;

public class Acceleration extends Vector {

	protected Acceleration(double magnitude, double angle) {
		super(magnitude, angle);
	}

	protected Acceleration(double magnitude, double angle, int startX, int startY) {
		super(magnitude, angle, startX, startY);
	}

	protected Acceleration(double xComponent, double yComponent, boolean isComponent) {
		super(xComponent, yComponent, isComponent);
	}

	protected Acceleration(int startX, int startY, double xComponent, double yComponent, boolean isComponent) {
		super(startX, startY, xComponent, yComponent, isComponent);
	}
	
	public static Acceleration createAccelerationWithComponents(int startX, int startY, double xComponent, double yComponent) {
		return new Acceleration(startX, startY, xComponent, yComponent, true);
	}

	public static Acceleration createAccelerationWithComponents(double xComponent, double yComponent) {
		return new Acceleration(xComponent, yComponent, true);
	}

	public static Acceleration createAccelerationPolarForm(double magnitude, double angle, int startX, int startY) {
		return new Acceleration(magnitude, angle, startX, startY);
	}

	public static Acceleration createAccelerationPolarForm(double magnitude, double angle) {
		return new Acceleration(magnitude, angle);
	}

}
