package zebra;

public class Main {
	public static void main(String[] args){
		PSR psr1 = new PSR1();
		Backtrack back = new Backtrack(psr1);
		Assignment result = back.recBacktrack(new Assignment());
		result.printAssignment(PSR1.varNames, psr1.N);
	}
}
