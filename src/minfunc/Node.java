package minfunc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Node implements Comparable<Node>{
	ArrayList<Node> sucessors;
	private double value;
	private Point p;
	private Random random = Main.random;
	
	
	public Node() {
		sucessors = new ArrayList<Node>();
	}
	
	public void setPoint(Point p) {
		this.p = p;
		calculateHeuristic();
	}
	
	public Point getPoint() {
		return p;
	}

	public Node highestSucessor() {
		//calculateHeuristic();
		//System.out.println("Value = "+value);
		generateSucessors();
		double aux = sucessors.get(0).getValue();
		int i;
		for(i = 0; i < sucessors.size(); i++) {
			if(sucessors.get(i).getValue() != aux)
				break;
		}
		
		int randIndex = random.nextInt(i);
		//System.out.println("rand = "+randIndex);
		//System.out.println("Valor do escolhido: "+sucessors.get(randIndex).getValue()+"x = "+sucessors.get(randIndex).getPoint().getX()+"  y = "+sucessors.get(randIndex).getPoint().getY());
		return sucessors.get(randIndex);
	}
	
	public Node randomSucessor(){
		generateSucessors();
		int randIndex = random.nextInt(sucessors.size());
		return sucessors.get(randIndex);
	}
	
	private void generateSucessors() {
		double auxX,auxY;
		//System.out.println("Determinando sucessores x = "+getPoint().getX()+"  y = "+getPoint().getY());
		for(int i = 0; i < Point.DEPTH+2; i++){
			for(int j = 0; j < Point.DEPTH+2; j++) {
				if(i != (Point.DEPTH+2)/2 ||  j != (Point.DEPTH+2)/2) {
					Node suc = new Node();
					auxX = p.getX() + Point.STEP*(j-Point.DEPTH);
					auxY = p.getY() + Point.STEP*(i-Point.DEPTH);
					Point sucP = new Point(auxX, auxY);
					suc.setPoint(sucP);
					
					//Calculando valor da heuristica
					suc.calculateHeuristic();
					
					//System.out.println("Sucessor["+j+"]["+i+"]: "+suc.getValue());
					sucessors.add(suc);
				}
							
				
			}
		}
		Collections.sort(sucessors);
	}
	
	private void calculateHeuristic() {
		this.value = TwoVarFunc.calc(p.getX(), p.getY());
	}
	

	public double getValue() {
		return value;
	}

	@Override
	public int compareTo(Node outro) {
		if (this.getValue() < outro.getValue())
			return 1;
		else if (this.getValue() > outro.getValue())
			return -1;
		else
			return 0;
			
	}
}
