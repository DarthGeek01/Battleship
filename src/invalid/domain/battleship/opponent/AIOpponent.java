package invalid.domain.battleship.opponent;

import invalid.domain.battleship.models.AbstractOpponent;
import invalid.domain.battleship.pieces.Peg;

public class AIOpponent implements AbstractOpponent {
	public AIOpponent() {
		
	}
	
	@Override
	public Peg getMove() {
		return null;
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

