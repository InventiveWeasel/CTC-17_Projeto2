package zebra;

import java.util.ArrayList;

public abstract class PSR implements Checker{
	public static int N;
	
	protected final int NOT_FOUND = -1;
	protected final int DEFAULT_VALUE = -1;
	protected boolean[] isAssigned;
	protected boolean[][] domainValues;
	
	public static String[] varNames;
	
	public int getMaxAssigns(){
		return N*N;
	}
	
	public abstract Var getUnassignedVar();

	public abstract ArrayList<Integer> getDomainValues(int domain);

}
