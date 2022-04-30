package a5;

/**
 * Root finding via Newton's method.
 *
 */
public class Newton implements RootFinder1 {

	// YOUR CLASS SHOULD PROVIDE ALL OF THE FEATURES
	// DESCRIBED BY ITS DOCUMENTATION

	public static final double TOL=1.0e-6;
	private Function1 df;
	
	public Newton(Function1 df) {
		this.df=df;
	}
	
	
	public Root root(Function1 f,double a,double b) {
		
		if(a>=b) {
			throw new IllegalArgumentException("a is greater than b");
		}
		
		double x=(a+b)/2;

		
		while(Math.abs(f.eval(x))>TOL){
			x=x-f.eval(x)/this.df.eval(x);
			if(x<a||x>b) {
				return Root.NONE;
			}
		}
		
		return new Root(x);
	}
	
	/**
	 * Small example program that finds a root of the sine and cosine function.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {

		// find the root of sin(x) on the interval [3, 4]
		Function1 sin = new Sine();
		Function1 cos = new Cosine(); // derivative of sin(x)
		Newton n = new Newton(cos);
		Root x0 = n.root(sin, 3.0, 4.0);
		if (x0 != Root.NONE) {
			System.out.println(x0.value()); // should be approx. pi
		}

		// find the root of cos(x) on the interval [1, 2]
		Function1 negsin = new NegSine();
		Newton n2 = new Newton(negsin); // derivative of cos(x)
		x0 = n2.root(cos, 1.0, 2.0);
		if (x0 != Root.NONE) {
			System.out.println(x0.value()); // should be approx. pi / 2
		}
	}

}
