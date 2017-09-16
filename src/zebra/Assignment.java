package zebra;

import java.util.HashMap;
import java.util.Map;

public class Assignment {
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
		return variables.get(varName).getValue();
	}
	
	public int getAssignsQuant(){
		return variables.size();
	}
}
