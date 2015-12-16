package invalid.domain.battleship.opponent;

import java.util.Random;

import invalid.domain.battleship.board.SelfBoard;
import invalid.domain.battleship.models.AbstractOpponent;
import invalid.domain.battleship.pieces.Peg;

public class AIOpponent implements AbstractOpponent {
	Random rand;
	SelfBoard board;
	
	boolean foundTrend;
	boolean lookingForTrend;
	
	
	public AIOpponent() {
		rand = new Random();
		board = new SelfBoard();
		foundTrend = false;
		lookingForTrend = false;
		
		board.addShipsRand();
	}
	
	@Override
	public Peg getMove() {
		if (!lookingForTrend && !foundTrend) {
			
		}
	}
	
	@Override
	public Boolean getResult() {
		return null;
	}
	
	@Override
	public void sendMove(Peg p) {
		
	}
	
	@Override
	public void sendResult(boolean b) {
		
	}
}

