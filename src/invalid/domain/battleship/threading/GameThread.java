package invalid.domain.battleship.threading;

import invalid.domain.battleship.board.SelfBoard;
import invalid.domain.battleship.opponent.NetworkOpponent;
import invalid.domain.battleship.models.AbstractOpponent;
import invalid.domain.battleship.pieces.Peg;

public class GameThread extends Thread {
	boolean gameIsRunning;
	boolean isTurn;
	boolean console;
	SelfBoard board;
	AbstractOpponent opponent;
	
	public GameThread(boolean isTurn, boolean console, SelfBoard board) {
		super();
		this.isTurn = isTurn;
		this.board = board;
		this.console = console;
	}
	
	@Override
	public void run() {
		gameIsRunning = true;
		Peg enemyMove;
		Peg selfMove = null;
		boolean result;
		
		while (gameIsRunning) {
			if (isTurn) {
				if (console)
					
				opponent.sendMove(selfMove);
				result = opponent.getResult();
				//GUI.handleResult(result);
				isTurn = false;
			} else {
				enemyMove = opponent.getMove();
				result = board.isHit(enemyMove);
				opponent.sendResult(result);
				isTurn = true;
			}
		}
	}
	
	public void stopGame() {
		gameIsRunning = false;
	}
	
	public boolean gameRunning() {
		return this.gameIsRunning;
	}
}
