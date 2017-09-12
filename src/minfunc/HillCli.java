package minfunc;


public class HillCli {
	Node current, next;
	
	public Node run(Point initialPoint) {
		int counter = 0;
		double currentValue;
		current = new Node();
		next = new Node();
		current.setPoint(initialPoint);
		Point suc;
		
		while(counter != 10) {
			suc = current.highestSucessor().getPoint();
			next.setPoint(new Point(suc.getX(), suc.getY()));
			//System.out.println("Sucessor: X = "+next.getPoint().getX()+"  Y = "+next.getPoint().getY());
			currentValue = current.getValue();
			if(next.getValue() < current.getValue())
				return current;
			
			
			if((currentValue - next.getValue()) < 0.00001) {
				//System.out.println("entrou");
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
