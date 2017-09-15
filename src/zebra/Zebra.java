package zebra;

public class Zebra {
	private final int N = 5;
	
	//Variaveis
	//variaveis
		//casas
		private int red;
		private int yellow;
		private int blue;
		private int green;
		private int ivory;
		
		//nacionalidades
		private int eng;
		private int spa;
		private int nor;
		private int ukr;
		private int jap;
		
		//animais
		private int dog;
		private int fox;
		private int snail;
		private int horse;
		private int zebra;
		
		//cigarros
		private int kool;
		private int chester;
		private int winston;
		private int lucky;
		private int parliament;
		
		//bebida
		private int juice;
		private int tea;
		private int coffee;
		private int milk;
		private int water;
	
	private House houses[];
	
	public Zebra() {
	}
	
	public boolean checkConsistency() {
		//O ingles mora na casa vermelha
		if(eng != red)
			return false;
		//O espanhol e dono do cachorro
		if(spa != dog)
			return false;
		//O noruegues mora na primeira casa a esquerda
		if(nor != 1)
			return false;
		//Fumam-se cigarros Kool na casa amarela
		if(kool != yellow)
			return false;
		//O homem que fuma cigarros Chesterfield mora na casa ao lado do homem
		//que mora com a raposa 
		if(Math.abs(chester-fox) != 1)
			return false;
		//O noruegues mora ao lado da casa azul
		if(Math.abs(nor-blue) != 1)
			return false;

		return true;
	}
}
