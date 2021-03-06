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
			next.setState(current.highestSucessor().getState());
			currentValue = current.getValue();
			if(-next.getValue() < -current.getValue() || current.getValue() == 0)
				return current;
			
			
			if(currentValue == next.getValue()) {
				counter++;
			} else {
				counter = 0;
				currentValue = next.getValue();
			}
			current.setState(next.getState());
			current.calculateHeuristic();
		}
		return current;
	}
}
