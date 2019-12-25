package vector;

public class KinematicsCalculator {
	
	public static Velocity getvelocity(Displacement d_i, Displacement d_f, double timeInterval) {
		d_f.setMagnitude(-1 * d_f.getMagnitude());
		Vector v1 = Vector.addVectors(d_i, d_f);
		v1.setMagnitude(v1.getMagnitude()/timeInterval);
		return Velocity.createVelocityWithComponents(v1.getStartX(), v1.getStartY(), v1.getxComponent(), v1.getyComponent());
	}
	
	public static Acceleration getAcceleration(Velocity v_i, Velocity v_f, double timeInterval) {
		Vector a1 = Vector.addVectors(v_i, v_f);
		a1.setMagnitude(a1.getMagnitude()/timeInterval);
		return Acceleration.createAccelerationWithComponents(a1.getStartX(), a1.getStartY(), a1.getxComponent(), a1.getyComponent());
	}
	
	public static Velocity getFinalVelocity(Velocity v_i, Acceleration a, double t) {
		a.setMagnitude(a.getMagnitude() * t);
		return (Velocity) Vector.addVectors(v_i, a);
	}
	
	public static Velocity getFinalVelocity(Velocity v_i, Acceleration a, Displacement s) {
		return Velocity.createVelocityPolarForm(Math.sqrt(Math.pow(v_i.getMagnitude(), 2) + 2 * s.getMagnitude() + a.getMagnitude()), a.getAngle(), a.getStartX(), a.getStartY());
	}
	
	public static Displacement getDisplacement(Velocity v_i, Acceleration a, double t) {
		return Displacement.createDisplacementPolarForm(v_i.getMagnitude() * t + 0.5 * a.getMagnitude() * t * t, a.getAngle(), a.getStartX(), a.getStartY());
	}
}
