package nqueens;

public class Queen {
	public static int N = 8;
	
	private int row, col;
	
	public Queen(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public boolean canAttack(Queen q) {
		return false;
	}
	
	public void setCol(int c) {
		col = c;
	}
	
	public void setRow(int r) {
		row = r;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
