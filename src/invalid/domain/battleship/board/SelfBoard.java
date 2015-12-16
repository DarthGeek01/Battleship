package invalid.domain.battleship.board;

import invalid.domain.battleship.pieces.Ship;
import invalid.domain.battleship.Battleship;
import invalid.domain.battleship.pieces.Peg;

import java.util.ArrayList;

public class SelfBoard {
	public final int BOARD_LEN_X;
	public final int BOARD_LEN_Y;
	
	private ArrayList<Ship> ships;
	private ArrayList<Peg> pegs;
	
	
	public SelfBoard() {
		this.BOARD_LEN_X = 10;
		this.BOARD_LEN_Y = 10;
		
		pegs = new ArrayList<>();
		ships = new ArrayList<>();
	}
	/*
	public void addPeg(Peg p) {
		pegs.add(p);
		
		for (Ship s : ships) {
			if (s.isHit(p)) {
				//gui.addRedPeg(s, p);
				return;
			}
		}
		
		//gui.addPeg(p);
	}*/
	
	public boolean isOccupied(Peg p) {
		for (Peg q : pegs) {
			if (p.getX() == q.getX() && p.getY() == q.getY())
				return true;
		}
		
		return false;
	}
	
	public boolean isHit(Peg p) {
		for (Ship s : ships) {
			if (s.isHit(p))
				return true;
		}
		
		return false;
	}
	
	public ArrayList<Peg> getPegs() {
		return pegs;
	}
	
	public ArrayList<Ship> getShips() {
		return ships;
	}
	
	/*
	public char getSpaceTxt(int x, int y) {
		Battleship.printDebug(ships);
		for (Ship s : ships) {
			Battleship.printDebug(s);
			if (s.isHit(new Peg(x, y)))
				return s.TEXT_REPRESENTATION;
		}
		
		for (Peg p : pegs) {
			if (p.getX() == x && p.getY() == y)
				return p.getText();
		}
		
		return ' ';
		//horribly inefficient, but the console mode is only for debugging
	}
	*/
	
	public boolean addShip(Ship ship) {
		//lazy, should do something better, but meh
		Battleship.printDebug("Adding ship");
		Battleship.printDebug(ship);
		for (Ship s : ships) {
			for (int i = s.START_POS; i <= s.END_POS; i++) {
				if (s.AXIS_ALIGNED == 'X') {
					if (ship.isHit(new Peg(s.ALIGN_AXIS_NUM, i)))
						return false;
				}
			}
		}
		
		return true;
	}
}
