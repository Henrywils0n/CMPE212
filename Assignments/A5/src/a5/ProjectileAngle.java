package a5;

/**
 * The ideal projectile angle function.
 *
 */
public class ProjectileAngle implements Function1 {
	
	// YOUR CLASS SHOULD PROVIDE ALL OF THE FEATURES
	// DESCRIBED BY ITS DOCUMENTATION
	
	public static final double G=9.80665;
	private double distance;
	private double speed;
	
	public ProjectileAngle(double distance, double speed) {
		if (distance<0||speed<0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		this.distance=distance;
		this.speed=speed;
	}
	
	
	public double eval(double x) {
		double rslt =this.distance*Math.tan(x)-0.5*G*(Math.pow(this.distance/(this.speed*Math.cos(x)), 2));
		if(! Double.isFinite(rslt)) {
			return Double.NaN;
		}
		return rslt;
		
	}
	
	
	public double getDistance() {
		
		if (distance<0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		return this.distance;
	}
	
	public double getSpeed() {
		if (speed<0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		return this.getSpeed();
	}
	
	public double setDistance(double distance) {
		double dist=this.distance;
		this.distance=distance;
		return dist;
	}
	
	public double setSpeed(double speed) {
		double sp=this.speed;
		this.speed=speed;
		return sp;
	}
	/**
	 * Small example program that finds the two possible aiming angles
	 * for a projectile launched at 32.0 m/s at a target located 100 m
	 * horizontally from the launch point.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		// target located 100 m horizontally from the launch point
		// launched at 50 m/s
		ProjectileAngle f = new ProjectileAngle(100.0, 30);
		
		// root finding using the bisection method
		Bisection n = new Bisection();
		
		// first angle is between 0 and 45 degrees 
		Root x0 = n.root(f, 0.0, Math.PI / 4.0);
		if (x0 != Root.NONE) {
			System.out.println(Math.toDegrees(x0.value()));
		}
		
		// second angle is between 45 and 90 degrees
		x0 = n.root(f, Math.PI / 4.0, Math.PI / 2.0);
		if (x0 != Root.NONE) {
			System.out.println(Math.toDegrees(x0.value()));
		}
		
	}

}
