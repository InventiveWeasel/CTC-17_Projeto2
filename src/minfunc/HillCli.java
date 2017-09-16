package minfunc;


public class HillCli {
	Node current, next;
	private double alfa = 0.5;
	private long Tinit = 1000000;
	
	public HillCli(){
		
	}
	
	public Node run(Point initialPoint) {
		int counter = 0;
		double currentValue;
		current = new Node();
		next = new Node();
		current.setPoint(initialPoint);
		Point suc;
		long T = Tinit;
		
		
		while(counter != 10) {
			suc = current.highestSucessor().getPoint();
			next.setPoint(new Point(suc.getX(), suc.getY()));
			//System.out.println("Sucessor: X = "+next.getPoint().getX()+"  Y = "+next.getPoint().getY());
			currentValue = current.getValue();
			if(next.getValue() < current.getValue())
				return current;
			
			
			if((currentValue - next.getValue()) < 0.00001) {
				counter++;
			} else {
				counter = 0;
				currentValue = next.getValue();
			}
			current.setPoint(new Point(next.getPoint().getX(), next.getPoint().getY()));
		}
		return current;
	}
	
}
