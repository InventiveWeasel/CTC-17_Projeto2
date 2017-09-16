package zebra;

import java.util.ArrayList;

public class PSR implements Checker{
	private final int N = 5;
	
	private final int NOT_FOUND = -1;
	private final int DEFAULT_VALUE = -1;
	
	public static String[] varNames = {
			"Vermelho", "Amarelo", "Azul", "Verde", "Marfim",
			"Ingles", "Espanhol", "Noruegues", "Ukraniano", "Japones",
			"Cachorro", "Raposa", "Caramujo", "Cavalo", "Zebra",
			"Kool", "Chester", "Winston", "Lucky Strike", "Parliament",
			"Suco de laranja", "Cha", "Cafe", "Leite", "Agua"};
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
	
	
	public PSR(){
		isAssigned = new boolean[N*N];
		domainValues = new boolean[N][N];
	}
	
	public Var getUnassignedVar(){
		for(int i = 0; i < isAssigned.length; i++){
			if(isAssigned[i] == false){
				Var var = new Var(i,-1,i/N);
				return var;
			}
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
	
	public boolean checkConsistency(Assignment a, Var var){
		a.addVar(var);
		boolean result = verifyVar(a);
		a.removeVar(var);
		if(result)
			return true;
		else{
			return false;
		}
	}
	
	public void setValueToVar(Var var, int value){
		isAssigned[var.getID()] = true;
		domainValues[var.getDomain()][value] = true;
		var.setValue(value);
	}
	
	public void removeValueOfVar(Var var) {
		isAssigned[var.getID()] = false;
		domainValues[var.getDomain()][var.getValue()] = false;
		var.setValue(DEFAULT_VALUE);
	}
	
	public boolean verifyVar(Assignment a) {
		int v1,v2;
		//O ingles mora na casa vermelha
		v1 = a.getValue(ENGLISH);
		v2 = a.getValue(RED);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O espanhol e dono do cachorro
		v1 = a.getValue(SPANISH);
		v2 = a.getValue(DOG);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O noruegues mora na primeira casa a esquerda
		v1 = a.getValue(NORWEGIAN);
		if(v1 != 0 && v1 != NOT_FOUND)
			return false;
		
		//Fumam-se cigarros Kool na casa amarela
		v1 = a.getValue(KOOL);
		v2 = a.getValue(YELLOW);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O homem que fuma cigarros Chesterfield mora na casa ao lado do homem
		//que mora com a raposa 
		v1 = a.getValue(CHESTER);
		v2 = a.getValue(FOX);
		if(Math.abs(v1 - v2) != 1 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O noruegues mora ao lado da casa azul
		v1 = a.getValue(NORWEGIAN);
		v2 = a.getValue(BLUE);
		if(Math.abs(v1 - v2) != 1 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O fumante de cigarros Winston cria caramujos
		v1 = a.getValue(WINSTON);
		v2 = a.getValue(SNAIL);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O fumante de cigarros Lucky Strike bebe suco de laranja
		v1 = a.getValue(LUCKY);
		v2 = a.getValue(JUICE);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O ucraniano bebe cha
		v1 = a.getValue(UKRANIAN);
		v2 = a.getValue(TEA);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//O japones fuma cigarros Parliament
		v1 = a.getValue(JAPANESE);
		v2 = a.getValue(PARLIAMENT);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//Fumam-se cigarros Kool em uma casa ao lado da casa em que fica o cavalo
		v1 = a.getValue(KOOL);
		v2 = a.getValue(HORSE);
		if(Math.abs(v1 - v2) != 1 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//Bebe-se cafe na casa verde
		v1 = a.getValue(GREEN);
		v2 = a.getValue(COFFEE);
		if(v1 != v2 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//A casa verde esta imediatamente a direita (a sua direita) da casa marfim
		v1 = a.getValue(GREEN);
		v2 = a.getValue(IVORY);
		if(v1 - v2 != 1 && v1 != NOT_FOUND && v2 != NOT_FOUND)
			return false;
		
		//Bebe-se leite na casa do meio
		v1 = a.getValue(MILK);
		if(v1 != 2 && v1 != NOT_FOUND)
			return false;
		return true;
	}
	
	public int getMaxAssigns(){
		return N*N;
	}

}
