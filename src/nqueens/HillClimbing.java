package nqueens;

public class HillClimbing {
	Node current, next;
	
	public Node run(Queen[] initialState) {
		int counter = 0;
		int currentValue;
		current = new Node();
		next = new Node();
		current.setState(initialState);
		current.calculateHeuristic();
		
		while(counter != 10) {
			//System.out.println("currentA: "+current.getValue());
			//System.out.println("nextA: "+next.getValue());
			next.setState(current.highestSucessor().getState());
			//System.out.println("currentB: "+current.getValue());
			//System.out.println("nextB: "+next.getValue());
			currentValue = current.getValue();
			if(-next.getValue() < -current.getValue() || current.getValue() == 0)
				return current;
			
			
			if(currentValue == next.getValue()) {
				//System.out.println("entrou");
				counter++;
			} else {
				counter = 0;
				currentValue = next.getValue();
			}
			//counter++;
			current.setState(next.getState());
			current.calculateHeuristic();
		}
		return current;
	}
}
