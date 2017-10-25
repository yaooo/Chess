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
//			Pawn temp = new Pawn("white");
//			b.getSquare("a3").setPiece(temp);
//			b.printBoard();
//			if(b.getSquare("a2").getPiece().isValidMove("a2","a4",b)) {
//				b.getSquare("a2").getPiece().move("a2","a4",b);
//				System.out.println("");
//				b.printBoard();
//			}
//			else {
//				System.out.println("non valid move");
//			}


			// Test for castling
			System.out.println("\nTest for castling");

			b.getSquare("d1").setPiece(null);
			b.getSquare("b1").setPiece(null);
			b.getSquare("c1").setPiece(null);
			b.getSquare("d2").setPiece(null);

			System.out.println(Movement.hasPiecesInBetween("e1", "c1", b));


			b.getSquare("e1").getPiece().move("e1", "c1", b);
			System.out.println("");
			b.printBoard();

			//Test for rook
//			b.getSquare("d1").getPiece().move("d1","d7",b);
//			b.getSquare("d1").getPiece().move("d1","d7",b);

//			b.printBoard();

		//i is rank, j is file
/*		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(b.getBoard()[i][j].getPieceType() == null){
					System.out.println("i+j:" + i +","+j);
				}
			}
		}*/
	}
}
