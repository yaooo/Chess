package chess;
import setup.*;
/**
 * @author Sagar Patel
 * @author Yao Shi
 * @version 1.0
 */

public class Chess {
	public static void main(String[] args) {
			Board b = new Board();
			b.initBoard();
			b.printBoard();
			b.getSquare("a7").getPiece().isValidMove("a7","a6",b);
			
	}
}
