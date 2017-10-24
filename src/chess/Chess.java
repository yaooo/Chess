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
			Pawn temp = new Pawn("white");
			b.getSquare("a3").setPiece(temp);
			b.printBoard();
			if(b.getSquare("a2").getPiece().isValidMove("a2","a4",b)) {
				b.getSquare("a2").getPiece().move("a2","a4",b);
				System.out.println("");
				b.printBoard();
			}
			else {
				System.out.println("non valid move");
			}


		//System.out.println(Movement.hasPiecesInBetween("a6", "b7",b));
		//System.out.println(Movement.hasPiecesInBetween("a1", "c3",b));
		//System.out.println(Movement.hasPiecesInBetween("c3", "a5",b));


		// i is rank, j is file
//		for(int i = 0; i < 8; i++){
//			for(int j = 0; j < 8; j++){
//				if(b.getBoard()[i][j].getPieceType() == null){
//					System.out.println("i+j:" + i +","+j);
//				}
//			}
//		}

	}
}
