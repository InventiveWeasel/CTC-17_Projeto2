package nqueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Node implements Comparable<Node>{
	ArrayList<Node> sucessors;
	private int value;
	public Queen[] state;
	private Random random = Main.random;
	
	
	public Node() {
		state = new Queen[Queen.N];
		sucessors = new ArrayList<Node>();
	}
	
	
	public void setState(Queen[] q) {
		for(int i = 0; i < Queen.N; i++) {
			state[i] = new Queen(q[i].getRow(), q[i].getCol());
		}
		calculateHeuristic();
	}
	
	public Queen[] getState() {
		return state;
	}

	public Node highestSucessor() {
		//calculateHeuristic();
		//System.out.println("Value = "+value);
		generateSucessors();
		int aux = sucessors.get(0).getValue();
		int i;
		for(i = 0; i < sucessors.size(); i++) {
			if(sucessors.get(i).getValue() != aux)
				break;
		}
		
		int randIndex = random.nextInt(i);
		//System.out.println("rand = "+randIndex);
		return sucessors.get(randIndex);
	}
	
	private void generateSucessors() {
		Queen[] auxState = new Queen[Queen.N];
		int actualRow;
		for(int i = 0; i < Queen.N; i++){
			for(int j = 0; j < Queen.N; j++) {
				Node suc = new Node();
				suc.setState(state);
				actualRow = suc.state[i].getRow();
				suc.state[i].setRow((actualRow + i) % Queen.N);
				
				//Calculando valor da heuristica
				suc.calculateHeuristic();
				
				sucessors.add(suc);
			}
		}
		Collections.sort(sucessors);
	}
	
	private void calculateHeuristic() {
		this.value = 0;
		for(int i = 0; i < Queen.N; i++) {
			for(int j = i+1; j < Queen.N; j++) {
				if(canAttack(i,j)) {
					this.value++;
				}
			}
		}
	}
	
	private boolean canAttack(int q1, int q2) {
		int r1,r2,c1,c2;
		r1 = state[q1].getRow();
		r2 = state[q2].getRow();
		c1 = state[q1].getCol();
		c2 = state[q2].getCol();
		//mesma linha ou coluna
		if(r1 == r2 || c1 == c2)
			return true;
		
		//Mesma diagonal
		if(Math.abs(r1 - r2) == Math.abs(c1 - c2))
			return true;
		return false;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Node outro) {
		if (this.getValue() < outro.getValue())
			return -1;
		else if (this.getValue() > outro.getValue())
			return 1;
		else
			return 0;
			
	}
}
