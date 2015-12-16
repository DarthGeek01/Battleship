package invalid.domain.battleship.pieces;

public class Ship {
	/**
	 * {@link ShipType} representing the type of this ship 
	 */
	public final ShipType SHIP_TYPE;
	/**
	 * {@link Peg} representing the point where this ship starts
	 */
	public final Peg START_POS;
	/**
	 * {@link Peg} representing the point where this ship ends
	 */
	public final Peg END_POS;
	/**
	 * {@link char} representing the axis on which this ship is aligned 
	 */
	public final char AXIS_ALIGNED;
	
	/**
	 * Constructor for the Ship class
	 * 
	 * @param type		The type of the ship. See {@link ShipType} for more info
	 * @param startPos	The position (inclusive) where this ship starts
	 * @param endPos	The position (also inclusive) where this ship ends
	 * @param axis		The axis this ship is aligned on
	 */
	public Ship(ShipType type, Peg startPos, Peg endPos, char axis) {
		this.SHIP_TYPE = type;
		this.START_POS = startPos;
		this.END_POS = endPos;
		this.AXIS_ALIGNED = axis;
	}
	
	/**
	 * Finds if a certain point is a hit on this ship by checking if either its X or Y value
	 * equal the value of the axis the ship is aligned on. If either of them are, then it 
	 * checks to see if it's other value are between the beginning and end points of this
	 * ship.
	 * 
	 * @param p	The point that is being tested to see if it's a hit
	 * @return	Whether or not the given point is a hit
	 */
	public boolean isHit(Peg p) {
		if (p.getX() == this.getAxisValue()) {
			if (p.getY() >= START_POS.getY() && p.getY() <= END_POS.getY())
				return true;
		} else if (p.getY() == this.getAxisValue()) {
			if (p.getX() >= START_POS.getX() && p.getX() <= END_POS.getX())
				return true;
		}
		
		return false;
	}
	
	/**
	 * Returns the value of the axis the ship is aligned on, if we treat the ship
	 * as a line segment. For example, if the ship is is vertical along x = 5, this 
	 * would return 5.
	 * 
	 * @return	the value of the axis the ship is aligned on
	 */
	private int getAxisValue() {
		if (this.AXIS_ALIGNED == 'x')
			return START_POS.getX();
		else
			return START_POS.getY();
	}
}
