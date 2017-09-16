package minfunc;

import java.util.Random;

import nqueens.HillClimbing;

public class Main {
	
	public static Random random = new Random();
	
	
	public static void main(String[] args) {
		//System.out.println("f(0,0) deve ser 4");
		//System.out.println(TwoVarFunc.calc(5, 5));
		random.setSeed(System.currentTimeMillis());
		long t0 = System.currentTimeMillis();
		Node result;
		int counter = 0;
		double aux = 0, delta = 1,max = 0;
		do {
			HillCli hc = new HillCli();
			result = hc.run(new Point(random.nextInt(100)-50,random.nextInt(100)-50));
			aux = result.getValue();
			if(aux > max) {
				delta = Math.abs(max-aux);
				max = aux;
				System.out.println("Ponto de parada");
				System.out.println("Valor: "+max);
				System.out.println("Coordenadas: ");
				System.out.println("X: "+result.getPoint().getX()+"   Y: "+result.getPoint().getY());
				System.out.println();
				counter++;
			}
		} while ((System.currentTimeMillis() - t0)/1000 < 20);
		System.out.println(delta);
		System.out.println(result.getValue());
		System.out.println(result.getPoint().getX());
		System.out.println(result.getPoint().getY());
	}
}
