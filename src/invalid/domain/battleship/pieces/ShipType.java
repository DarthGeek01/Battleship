package invalid.domain.battleship.pieces;

public enum ShipType {
	CARRIER(5), 
	BATTLESHIP(4), 
	CRUISER(3), 
	SUBMARINE(3), 
	DESTROYER(2);
	
	/**
	 * The number of spaces each given enum value takes up
	 */
	private int numSpaces;
	
	/**
	 * Private so it can only be called from within the enum, effectively making the numbers
	 * above constant
	 * 
	 * @param spaces	The number of spaces each given value takes
	 */
	private ShipType(int spaces) {numSpaces = spaces;}
	
	/**
	 * Accessor for numSpaces
	 * 
	 * @return the number of spaces the set value takes up
	 */
	public int getNumSpaces() {return numSpaces;}
}
