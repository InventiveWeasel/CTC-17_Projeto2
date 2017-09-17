package zebra;

import java.util.HashMap;
import java.util.Map;

public class Assignment {
	private final int NOT_FOUND = -1;
	
	private Map<Integer,Var> variables;
	
	public Assignment() {
		variables = new HashMap<Integer,Var>();
	}
	
	public void addVar(Var var){
		variables.put(var.getID(),var);
	}
	
	public void removeVar(Var var){
		variables.remove(var.getID());
	}
	
	public int getValue(int varName){
		int value;
		try{
			value = variables.get(varName).getValue();
		} catch(NullPointerException e){
			return NOT_FOUND;
		}
		
		return value; 
	}
	
	public int getAssignsQuant(){
		return variables.size();
	}
	
	public void printAssignment(String[] varNames, int nDom){
		Var var;
		int zebra = 0, agua = 0;
		for(int i = 0; i < nDom; i++){
			System.out.println("Casa "+i+":");
			for(int j = 0; j < varNames.length; j++){
				var = variables.get(j);
				if(var.getValue() == i)
					System.out.println(varNames[var.getID()]);
				if(varNames[var.getID()].equals("Zebra"))
					zebra = var.getValue();
				if(varNames[var.getID()].equals("Agua"))
					agua = var.getValue();
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
		System.out.println("RESPOSTAS");
		System.out.println("Onde vive a zebra?");
		System.out.println("R: Na casa "+zebra);
		System.out.println();
		System.out.println("Onde se bebe agua?");
		System.out.println("R: Na casa "+agua);
	}
}
