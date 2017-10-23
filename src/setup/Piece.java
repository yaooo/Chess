/**
 * 
 */
package setup;
public abstract class Piece implements Cloneable {

	boolean isWhite;
	String type;
	boolean hasMoved;

	
	public Piece(String color) {
		isWhite = color.equals("white");
		type = null;
		hasMoved = false;
	}
	
	/**
	 * isWhite()
	 * Checks to see whether a piece is white, returns true if white
	 * @return boolean
	 */
	public boolean isWhite() {
		return isWhite;
	}
	
	/**
	 * hasMoved()
	 * Checks to see whether a piece has moved previous, returns true if yes
	 * @return boolean
	 * 
	 
//	public boolean hasMoved() {
//		return hasMoved;
//	}
//	
//	/**
//	 * moved()
//	 * Updates hasMoved boolean as true to indicated a piece has moved
//	 * @return void
//	 */
//	public void moved() {
//		hasMoved = true;
//	}
	
	/**
	 * testForCheck()
	 * Checks whether a piece puts enemy king in check, returns true if king is in check
	 * @return boolean
	 * 
	 * 
	 */
	public boolean testForCheck(char file, char rank, Square[][] board, String currentColor) {

		
		//TODO: finish this method

		return false;
	}
	
//	/**
//	 * getEnemyKingLocation()
//	 * Gets string of enemy kings location
//	 * @return string
//	 * 
//	 * 
//	 */
//	public String getEnemyKingLocation(Square[][] board, String currentColor) {
//		String location = "";
//		return location;
//	}
	
	/**
	 * isValidMove
	 * @param input
	 * @param board
	 * @return if the move is valid
	 */
	public abstract boolean isValidMove(String start,String input, Board board);
	
	/**
	 * @param input
	 * @param board
	 * @return the board after moving
	 */
	public abstract Square[][] move(String input, Square[][] board);
	
	/**
	 * canEnpassant()
	 * @return boolean
	 * 
	 * Returns boolean indicating whether this piece can enpassant
	 */
	public boolean canEnpassant()
	{
		return false;
	}
	
	/**
	 * getEnpassant()
	 * @return boolean
	 * Returns boolean indicating whether this piece can be captured by enpassant
	 */
	public boolean getEnpassant()
	{
		return false;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	
//	/**
//	 * setHasMoved
//	 * @param m  true if has moved, else false
//	 */
//	public void setHasMoved(boolean m) {
//		hasMoved = m;
//	}
//	
}
