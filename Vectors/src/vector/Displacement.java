package vector;

public class Displacement extends Vector{

	protected Displacement(double xComponent, double yComponent, boolean isComponent) {
		super(xComponent, yComponent, isComponent);
	}

	protected Displacement(double magnitude, double angle, int startX, int startY) {
		super(magnitude, angle, startX, startY);
	}

	protected Displacement(double magnitude, double angle) {
		super(magnitude, angle);
	}

	protected Displacement(int startX, int startY, double xComponent, double yComponent, boolean isComponent) {
		super(startX, startY, xComponent, yComponent, isComponent);
	}
	
	public static Displacement createDisplacementWithComponents(int startX, int startY, double xComponent, double yComponent) {
		return new Displacement(startX, startY, xComponent, yComponent, true);
	}

	public static Displacement createDisplacementWithComponents(double xComponent, double yComponent) {
		return new Displacement(xComponent, yComponent, true);
	}

	public static Displacement createDisplacementPolarForm(double magnitude, double angle, int startX, int startY) {
		return new Displacement(magnitude, angle, startX, startY);
	}

	public static Vector createDisplacementPolarForm(double magnitude, double angle) {
		return new Vector(magnitude, angle);
	}	

}
