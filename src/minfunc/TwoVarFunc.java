package minfunc;

public class TwoVarFunc {
	
	
	public static double calc(double x, double y) {
		double t1,t2,t3,t4,t5;
		t1 = 4 * Math.exp(-(Math.pow(x, 2) + Math.pow(y, 2)));
		t2 = Math.exp(-(Math.pow(x-5, 2) + Math.pow(y-5, 2)));
		t3 = Math.exp(-(Math.pow(x+5, 2) + Math.pow(y-5, 2)));
		t4 = Math.exp(-(Math.pow(x-5, 2) + Math.pow(y+5, 2)));
		t5 = Math.exp(-(Math.pow(x+5, 2) + Math.pow(y+5, 2)));
		return t1 + t2 + t3 + t4 + t5;
	}
}
