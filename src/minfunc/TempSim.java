package minfunc;

import java.util.Random;

public class TempSim {
	Node current, next;
	private double alfa = 0.5;
	private long Tinit = 1000000;
	
	public TempSim(){
		
	}
	
	public Node run(Point initialPoint) {
		current = new Node();
		next = new Node();
		current.setPoint(initialPoint);
		Point suc;
		long T = Tinit;
		double delta;
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		
		while(true) {
			if(T == 0)
				return current;
			
			suc = current.randomSucessor().getPoint();
			next.setPoint(new Point(suc.getX(), suc.getY()));
			//System.out.println("Sucessor: X = "+next.getPoint().getX()+"  Y = "+next.getPoint().getY());
			
			delta = next.getValue() - current.getValue();
			
			if(delta > 0)
				current.setPoint(new Point(next.getPoint().getX(), next.getPoint().getY()));
			else{
				double aux = Math.exp(delta/T);
				if(rand.nextDouble() < aux)
					current.setPoint(new Point(next.getPoint().getX(), next.getPoint().getY()));
			}
			T = (long) (T*alfa);
		}
	}
	
}
