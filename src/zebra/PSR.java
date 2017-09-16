package zebra;

import java.util.ArrayList;

public class PSR implements Checker{
	private final int N = 5;
	
	//Variaveis
	//Casas
	private final int RED = 0;
	private final int YELLOW = 1;
	private final int BLUE = 2;
	private final int GREEN = 3;
	private final int IVORY = 4;
	
	//Nacionalidades
	private final int ENGLISH = 5;
	private final int SPANISH = 6;
	private final int NORWEGIAN = 7;
	private final int UKRANIAN = 8;
	private final int JAPANESE = 9;
	
	//Animais
	private final int DOG = 10;
	private final int FOX = 11;
	private final int SNAIL = 12;
	private final int HORSE = 13;
	private final int ZEBRA = 14;
	
	//Cigarros
	private final int KOOL = 15;
	private final int CHESTER = 16;
	private final int WINSTON = 17;
	private final int LUCKY = 18;
	private final int PARLIAMENT = 19;
	
	//BEBIDA
	private final int JUICE = 20;
	private final int TEA = 21;
	private final int COFFEE = 22;
	private final int MILK = 23;
	private final int WATER = 24;
	
	private boolean[] isAssigned;
	private boolean[][] domainValues;
	//private String[] varNames = {
	//		"english", "spanish", "norwegian", "ukranian", "japanese"};
	
	/*
	//Casas
		private final String RED = "red";
		private final String YELLOW = "yellow";
		private final String BLUE = "blue";
		private final String GREEN = "green";
		private final String IVORY = "ivory";
		
		//Nacionalidades
		private final String ENGLISH = "english";
		private final String SPANISH = "spanish";
		private final String NORWEGIAN = "norwegian";
		private final String UKRANIAN = "ukranian";
		private final String JAPANESE = "japanese";
		
		//Animais
		private final String DOG = "dog";
		private final String FOX = "fox";
		private final String SNAIL = "snail";
		private final String HORSE = "horse";
		private final String ZEBRA = "zebra";
		
		//Cigarros
		private final String KOOL = "kool";
		private final String CHESTER = "chester";
		private final String WINSTON = "winston";
		private final String LUCKY = "lucky";
		private final String PARLIAMENT = "parliament";
		
		//BEBIDA
		private final String JUICE = "orange juice";
		private final String TEA = "tea";
		private final String COFFEE = "coffee";
		private final String MILK = "milk";
		private final String WATER = "water";
	*/	
	
	public PSR(){
		isAssigned = new boolean[N*N];
		domainValues = new boolean[N][N];
	}
	
	public Var getUnassignedVar(){
		for(int i = 0; i < isAssigned.length; i++){
			if(isAssigned[i] == false)
				return new Var(i,-1,i/N);
		}
		return null;
	}
	
	public ArrayList<Integer> getDomainValues(int domain){
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 0; i < N; i++){
			if(domainValues[domain][i] == false)
				values.add(i);
		}
		return values;
	}
	
	public boolean checkConsistency(Assignment a) {
		//O ingles mora na casa vermelha
		if(a.getValue(ENGLISH) != a.getValue(RED))
			return false;
		//O espanhol e dono do cachorro
		if(a.getValue(SPANISH) != a.getValue(DOG))
			return false;
		//O noruegues mora na primeira casa a esquerda
		if(a.getValue(NORWEGIAN) != 1)
			return false;
		//Fumam-se cigarros Kool na casa amarela
		if(a.getValue(KOOL) != a.getValue(YELLOW))
			return false;
		//O homem que fuma cigarros Chesterfield mora na casa ao lado do homem
		//que mora com a raposa 
		if(Math.abs(a.getValue(CHESTER)-a.getValue(FOX)) != 1)
			return false;
		//O noruegues mora ao lado da casa azul
		if(Math.abs(a.getValue(NORWEGIAN)-a.getValue(BLUE)) != 1)
			return false;
		//O fumante de cigarros Winston cria caramujos
		if(a.getValue(WINSTON) != a.getValue(SNAIL))
			return false;
		//O fumante de cigarros Lucky Strike bebe suco de laranja
		if(a.getValue(LUCKY) != a.getValue(JUICE))
			return false;
		//O ucraniano bebe cha
		if(a.getValue(UKRANIAN) != a.getValue(TEA))
			return false;
		//O japones fuma cigarros Parliament
		if(a.getValue(JAPANESE) != a.getValue(PARLIAMENT))
			return false;
		//Fumam-se cigarros Kool em uma casa ao lado da casa em que fica o cavalo
		if(Math.abs(a.getValue(KOOL) - a.getValue(HORSE)) != 1)
			return false;
		//Bebe-se cafe na casa verde
		if(a.getValue(GREEN) != a.getValue(COFFEE))
			return false;
		//A casa verde esta imediatamente a direita (a sua direita) da casa marfim
		if(a.getValue(GREEN)-a.getValue(IVORY) != 1)
			return false;
		//Bebe-se leite na casa do meio
		if(a.getValue(MILK)!=3)
			return false;
		return true;
	}
	
	public int getMaxAssigns(){
		return N*N;
	}

}
