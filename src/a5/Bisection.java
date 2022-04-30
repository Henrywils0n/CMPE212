package a5;

/**
 * Root finding via the bisection method.
 *
 */
public class Bisection implements RootFinder1 {

	// YOUR CLASS SHOULD PROVIDE ALL OF THE FEATURES
	// DESCRIBED BY ITS DOCUMENTATION
	
	public static final double TOL=1.0e-6;
	
	
	public Root root(Function1 f,double a,double b) {
		
		if (a>=b) throw new IllegalArgumentException ("a>=b");
		if (Math.signum(f.eval(a))==Math.signum(f.eval(b))) throw new IllegalArgumentException("Evaluate at same sign");
		
		double c=(a+b)/2;
		while(Math.abs(f.eval(c))>TOL) {
			
			if(Math.signum(f.eval(a))==Math.signum(f.eval(c))) {
				a=c;
			}
			else if(Math.signum(f.eval(b))==Math.signum(f.eval(c))) {
				b=c;
			}
			
			c=(a+b)/2;
			if(c<a||c>b) {
				return Root.NONE;
			}
			
		}
		
		return new Root(c);
	}

	/**
	 * Small example program that finds a root of the sine and cosine functions.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		// find the root of sin(x) on the interval [3, 4]
		Function1 sin = new Sine();
		Bisection bisect = new Bisection();
		Root x0 = bisect.root(sin,2, 4);
		if (x0 != Root.NONE) {
			System.out.println(x0.value()); // should be approx. pi
		}

		// find the root of cos(x) on the interval [1, 2]
		Function1 cos = new Cosine();
		x0 = bisect.root(cos, 1.0, 2.0);
		if (x0 != Root.NONE) {
			System.out.println(x0.value()); // should be approx. pi / 2
		}
	}

}
