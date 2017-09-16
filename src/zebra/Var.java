package zebra;

public class Var {
	private int id;
	private int value;
	private int domain;
	
	public Var(int id, int v, int d) {
		setValue(v);
		setDomain(d);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDomain() {
		return domain;
	}

	public void setDomain(int domain) {
		this.domain = domain;
	}
	
	public int getID(){
		return id;
	}
}
