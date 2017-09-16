package zebra;

public class Var {
	private int id;
	private int value;
	private int dom;
	
	public Var(int id, int v, int d) {
		this.id = id;
		this.value = v;	
		this.dom = d;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDomain() {
		return dom;
	}

	public void setDomain(int domain) {
		this.dom = domain;
	}
	
	public int getID(){
		return id;
	}
}
