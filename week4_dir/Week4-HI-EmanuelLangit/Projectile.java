// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Projectile.java
// Projectile class for Week 4 Assignment
// Week 4 Assignment
// July 31, 2013


public class Projectile {
	
	private double initialVelocity;
	private double launchAngle;
	private static final int gravity = 10; // gravitational acceleration in meters/sec^2
	
	// no argument constructor
	public Projectile() {
		initialVelocity = 0;
		launchAngle = 0;
	}
	
	public Projectile (double velocity, double angle) {
		if (velocity >= 0) {
			initialVelocity = velocity;
		}
		
		if ((angle >= 0) && (angle <= 90)) {
			launchAngle = angle;
		}
		
	}
	
	public void setInitialVelocity(double velocity) {
		if (velocity > 0) {
			initialVelocity = velocity;
		}
	}
	
	public double getInitialVelocity() {
		return initialVelocity;
	}
	
	public void setLaunchAngle(double angle) {
		if ((angle >= 0) && (angle <= 90)) {
			launchAngle = angle;
		}
	}
	
	public double getLaunchAngle() {
		return launchAngle;
	}
	
	public double getVerticalComponent() {
		return (getInitialVelocity() * Math.sin(Math.toRadians(launchAngle)));
	}
	
	
	public double getHorizontalComponent() {
		return (getInitialVelocity() * Math.cos(Math.toRadians(launchAngle)));
	}
	
	public double getTravelTime() {
		return ((2 * getVerticalComponent())/gravity);
	}
	
	public double getDistanceTraveled() {
		return (getHorizontalComponent() * getTravelTime());
	}
	
	@Override
	public String toString() {
		String result = "Horizontal component: " + String.format("%.2f", getHorizontalComponent()) + "\n" +
						"Vertical component: " + String.format("%.2f", getVerticalComponent()) + "\n" +
						"Distance traveled: " + String.format("%.2f", getDistanceTraveled()) + " meters\n" +
						"Travel time: " + String.format("%.2f", getTravelTime()) + " seconds\n";
		return result;
	}
}
