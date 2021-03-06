package invalid.domain.battleship;

import java.util.Random;

import invalid.domain.battleship.board.SelfBoard;
import invalid.domain.battleship.console.ConsoleManager;
import invalid.domain.battleship.pieces.Peg;
import invalid.domain.battleship.pieces.Ship;
import invalid.domain.battleship.pieces.ShipType;
//import invalid.domain.battleship.gui.BattleshipGui;
import invalid.domain.battleship.threading.GameThread;

public class Battleship {
	private static GameThread gameMan;
	private static boolean debug;
	//private static BattleshipGui gui;
	
	public static void main(String[] args) {
		//gui = new BattleshipGui();
		debug = true;
		SelfBoard board = new SelfBoard();
		board.addShipsRand();
		Battleship.printDebug(board.getShips());
	}
	
	public static GameThread getGameMan() {
		return gameMan;
	}
	
	public static void printDebug(String s) {
		if (debug)
			System.out.println("[DEBUG] " + s);
	}
	
	public static void printDebug(Object o) {
		if (debug)
			System.out.println("[DEBUG] " + (o == null ? "NULL" : o.toString()));
	}
	
	/*public static BattleshipGui getGui() {
		return gui;
	}*/
}
