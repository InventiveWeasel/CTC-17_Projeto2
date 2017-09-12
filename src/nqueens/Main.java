package nqueens;

import java.util.Random;

public class Main {
		
	public static Random random = new Random();
	
	
	public static void main(String[] args) {
		long starttime,endtime;
		starttime = System.currentTimeMillis();
		Node result;
		random.setSeed(123456789);
		//Estado inicial aleatório
		do {
			Queen[] state = new Queen[Queen.N];
			
			for(int i = 0; i < Queen.N ; i++) {
				state[i] = new Queen(random.nextInt(Queen.N), i);
			}
			//printState(state);
			
			HillClimbing hc = new HillClimbing();
			result = hc.run(state);
		} while(result.getValue()!= 0);
		endtime = System.currentTimeMillis();
		printState(result.getState());
		System.out.println("Tempo total: "+(endtime-starttime)/1000);
	}
	
	public static void printState(Queen[] q) {
		String[][] board = new String[Queen.N][Queen.N];
		
		for(int i = 0; i < Queen.N; i++) {
			for(int j = 0; j < Queen.N; j++) {
				board[i][j] = "X ";
			}
		}
		
		for(int i = 0; i < Queen.N; i++) {
			board[q[i].getRow()][q[i].getCol()] = "Q ";
		}
		
		String result = "";
		for(int i = 0; i < Queen.N; i++) {
			for(int j = 0; j < Queen.N; j++) {
				result = result+board[i][j];
			}
			result = result+"\n";
		}
		System.out.println(result);
	}
}
