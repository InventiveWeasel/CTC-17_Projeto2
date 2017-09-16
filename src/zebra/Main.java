package zebra;

public class Main {
	public static void main(String[] args){
		PSR psr = new PSR();
		Backtrack back = new Backtrack(psr);
		Assignment result = back.recBacktrack(new Assignment());
		result.printAssignment(PSR.varNames);
	}
}
