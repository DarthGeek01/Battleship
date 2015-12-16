package invalid.domain.battleship.pieces;

import java.awt.Point;

public class Peg {
	@SuppressWarnings("unused")		  //I loathe the yellow warning sign
	private final String id = "targetPeg"; //since object is serialized with Gson, easier this way
	private final int X;
	private final int Y;
	private final boolean IS_RED;
	
	public Peg(int x, int y, boolean isRed) {
		this.X = x;
		this.Y = y;
		
		this.IS_RED = isRed;
	}
	
	public Peg(int x, int y) {
		this(x, y, false);
	}
	
	public Peg(Point p, boolean isRed) {
		this((int) p.getX(), (int) p.getY(), isRed);
	}
	
	public Peg(Point p) {
		this((int) p.getX(), (int) p.getY());
	}

	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public char getText() {
		return (this.IS_RED) ? '#' : '@';
	}
	
	public boolean isRed() {
		return this.IS_RED;
	}
}
