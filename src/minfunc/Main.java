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
		double aux = 0,max = 0;
		double maxX=1000, maxY=1000;
		do {
			TempSim hc = new TempSim();
			result = hc.run(new Point(random.nextInt(100)-50,random.nextInt(100)-50));
			aux = result.getValue();
			if(aux > max) {
				max = aux;
				maxX = result.getPoint().getX();
				maxY = result.getPoint().getY();
				System.out.println("Ponto de parada");
				System.out.println("Valor: "+max);
				System.out.println("Coordenadas: ");
				System.out.println("X: "+maxX+"   Y: "+maxY);
				System.out.println();
			}
		} while ((System.currentTimeMillis() - t0)/1000 < 20);
		System.out.println("---------------------------------");
		System.out.println("RESULTADO");
		System.out.println("Valor Maximo: "+max);
		System.out.println("Coordenadas: ");
		System.out.println("X: "+maxX+"   Y: "+maxY);

	}
}
