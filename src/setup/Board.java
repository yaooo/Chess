package setup;

/**
 * @author Sagar Patel
 * @author Yao Shi
 * @version 1.0
 */


public class Board {

	private Square[][] board;
	
	public Board() {
		this.board = new Square[8][8];
	}
	
	public Square[][] getBoard() {
		return this.board;
	}
	
}
