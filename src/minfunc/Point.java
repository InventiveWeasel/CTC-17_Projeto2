package minfunc;

public class Point {
	private double x, y;
	public final static int DEPTH = 1;
	public static int N = (int) (Math.pow(DEPTH+2, 2)-1);
	public static double STEP = 0.1;
	
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
