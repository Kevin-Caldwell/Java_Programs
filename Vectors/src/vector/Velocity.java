package vector;

public class Velocity extends Vector{

	protected Velocity(double xComponent, double yComponent, boolean isComponent) {
		super(xComponent, yComponent, isComponent);
	}

	protected Velocity(double magnitude, double angle, int startX, int startY) {
		super(magnitude, angle, startX, startY);
	}

	protected Velocity(double magnitude, double angle) {
		super(magnitude, angle);
	}

	protected Velocity(int startX, int startY, double xComponent, double yComponent, boolean isComponent) {
		super(startX, startY, xComponent, yComponent, isComponent);
	}
	
	public static Velocity createVelocityWithComponents(int startX, int startY, double xComponent, double yComponent) {
		return new Velocity(startX, startY, xComponent, yComponent, true);
	}

	public static Velocity createVelocityWithComponents(double xComponent, double yComponent) {
		return new Velocity(xComponent, yComponent, true);
	}

	public static Velocity createVelocityPolarForm(double magnitude, double angle, int startX, int startY) {
		return new Velocity(magnitude, angle, startX, startY);
	}

	public static Velocity createVelocityPolarForm(double magnitude, double angle) {
		return new Velocity(magnitude, angle);
	}

}
