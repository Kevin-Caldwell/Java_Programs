/**
 * 
 */
package vector;

/**
 * @author Kevin C.
 * A force class
 */
public class Force extends Vector {

	/**
	 * public constructor for Force class
	 */
	protected Force(double magnitude, double direction) {
		super(magnitude, direction);
	}
	
	protected Force(double xComponent, double yComponent, boolean isComponent) {
		super(xComponent, yComponent, isComponent);
	}

	protected Force(double magnitude, double angle, int startX, int startY) {
		super(magnitude, angle, startX, startY);
	}

	protected Force(int startX, int startY, double xComponent, double yComponent, boolean isComponent) {
		super(startX, startY, xComponent, yComponent, isComponent);
	}

	public static Force createForceWithComponents(int startX, int startY, double xComponent, double yComponent) {
		return new Force(startX, startY, xComponent, yComponent, true);
	}

	public static Force createForceWithComponents(double xComponent, double yComponent) {
		return new Force(xComponent, yComponent, true);
	}

	public static Force createForcePolarForm(double magnitude, double angle, int startX, int startY) {
		return new Force(magnitude, angle, startX, startY);
	}

	public static Force createForcePolarForm(double magnitude, double angle) {
		return new Force(magnitude, angle);
	}

}
