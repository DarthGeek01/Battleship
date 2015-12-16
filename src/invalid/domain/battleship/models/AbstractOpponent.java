package invalid.domain.battleship.models;

import invalid.domain.battleship.pieces.Peg;

public interface AbstractOpponent {
	public abstract Peg getMove();
	public abstract Boolean getResult();
	public abstract void sendMove(Peg p);
	public abstract void sendResult(boolean b);
}
