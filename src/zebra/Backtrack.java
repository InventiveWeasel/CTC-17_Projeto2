package zebra;

import java.util.ArrayList;

public class Backtrack {
	private PSR psr;
	
	public Backtrack(PSR psr){
		this.psr = psr;
	}
	
	public Assignment recBacktrack(Assignment a){
		Var var;
		ArrayList<Integer> domainValues;
		Assignment result;
		
		if(isComplete(a))
			return a;
		var = psr.getUnassignedVar();
		domainValues = psr.getDomainValues(var.getDomain());
		for(int i = 0; i < domainValues.size(); i++){
			var.setValue(domainValues.get(i));
			//testando o valor
			if(psr.checkConsistency(a)){
				result = recBacktrack(a);
				if(result != null)
					return result;
				a.removeVar(var);
			}
		}
		return null;
		
	}
	
	private boolean isComplete(Assignment a){
		if(a.getAssignsQuant() == psr.getMaxAssigns())
			return true;
		return false;
	}
}
