package zebra;

public interface Checker {
	public boolean checkConsistency(Assignment a, Var var);
	public void setValueToVar(Var var, int i);
	public void removeValueOfVar(Var var);
}
