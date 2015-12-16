package invalid.domain.battleship.board;

import invalid.domain.battleship.pieces.Ship;
import invalid.domain.battleship.pieces.ShipType;
import invalid.domain.battleship.Battleship;
import invalid.domain.battleship.pieces.Peg;

import java.util.ArrayList;
import java.util.Random;

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
			for (Peg p : ship.getPegs()) {
				if (s.isHit(p))
					return false;
			}
		}
		
		ships.add(ship);
		return true;
	}
	
	public void addShipsRand() {
		Battleship.printDebug("Placing ships randomly...");
		Random rand = new Random();
		ArrayList<Peg> usedSpaces = new ArrayList<Peg>();
		char currentAxis = ' ';
		ShipType currentShip = null;
		int currentX = 0;
		int secondX = 0;
		int currentY = 0;
		int secondY = 0;
		boolean searching = true;
		
		for (int i = 0; i < 5; i++) {
			searching = true;
			switch(i) {
			case 0:
				currentShip = ShipType.CARRIER;
				break;
			case 1:
				currentShip = ShipType.BATTLESHIP;
				break;
			case 2:
				currentShip = ShipType.CRUISER;
				break;
			case 3:
				currentShip = ShipType.SUBMARINE;
				break;
			case 4:
				currentShip = ShipType.DESTROYER;
				break;
			default:
				break;
			}
			
			while (searching) {
				currentAxis = (rand.nextInt(2) == 0) ? 'y' : 'x';
				if (currentAxis == 'y') {
					currentX = rand.nextInt(10 - currentShip.getNumSpaces()) + 1;
					secondX = (currentX + currentShip.getNumSpaces()) - 1;
					currentY = rand.nextInt(10) + 1;
					secondY = currentY;
				} else {
					currentY = rand.nextInt(10 - currentShip.getNumSpaces()) + 1;
					secondY = (currentY + currentShip.getNumSpaces()) - 1;
					currentX = rand.nextInt(10) + 1;
					secondX = currentX;
				}
				
				if(addShip(new Ship(currentShip, new Peg(currentX, currentY), 
						new Peg(secondX, secondY), currentAxis)))
					searching = false;
			}
		}
		
	}
}
