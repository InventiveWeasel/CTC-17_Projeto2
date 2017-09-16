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
	
	public void printAssignment(String[] varNames){
		Var var;
		for(int i = 0; i < variables.size(); i++){
			var = variables.get(i);
			System.out.println("ID: "+varNames[var.getID()]+"  Value: "+var.getValue());
		}
	}
}
