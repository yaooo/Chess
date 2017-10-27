package chess;
import setup.*;
import java.util.Scanner;
/**
 * @author Sagar Patel
 * @author Yao Shi
 * @version 1.0
 */

public class Chess {
	public static void main(String[] args) {
			Board b = new Board();
			b.initClearBoard();
			King whiteKing=new King("white");
			whiteKing.kingPos="h1";
			Rook blackR=new Rook("black");
			Bishop blackB=new Bishop("black");
			Rook blackR2=new Rook("black2");
			b.getSquare("h1").setPiece(whiteKing);
			b.getSquare("h4").setPiece(blackR);
			b.getSquare("a8").setPiece(blackB);
			b.getSquare("a1").setPiece(blackR2);
			b.printBoard();
			System.out.println(b.getSquare("h1").getPiece().inCheck(b));
			System.out.println(b.getSquare("h1").getPiece().checkMate(b));
//			Scanner scn=new Scanner(System.in);
//			b.initBoard();
//			Square whiteKing=b.getSquare("e1");
//			Square blackKing=b.getSquare("e8");
//			b.printBoard();
//			String input;
//			boolean whiteTurn=true;
//			System.out.println("White player make your move.");
//			input=scn.nextLine();
//			String parts[]=input.split(" ");
//			Pawn PassantTrack=null;
//			while(!(parts[0].equals("resign"))){
//				if(b.getSquare(parts[0]).getPieceColor().equals("w") && whiteTurn==false) {
//					System.out.println("illegal move,try again1");
//				}
//				else if(b.getSquare(parts[0]).getPieceColor().equals("b")&& whiteTurn==true) {
//					System.out.println("illegal move,try again2");
//				}
//				else if(b.getSquare(parts[0]).getPiece().isValidMove(parts[0], parts[1], b)) {
//					b.getSquare(parts[0]).getPiece().move(parts[0],parts[1],b);
//					if (b.getSquare(parts[1]).getPieceType().equals("K")){
//						if(b.getSquare(parts[1]).getPiece().isWhite()==true) {
//							whiteKing=b.getSquare(parts[1]);
//						}
//						else {
//							blackKing=b.getSquare(parts[1]);
//						}
//							
//					}
//					if(b.getSquare(parts[1]).getPieceType().equals("p")){
//						if(PassantTrack==null) {
//							PassantTrack=(Pawn)b.getSquare(parts[1]).getPiece();
//						}
//						else{
//							PassantTrack.setEnpassant();
//							PassantTrack=(Pawn)b.getSquare(parts[1]).getPiece();
//						}
//					}
//					else if(PassantTrack!=null && !(b.getSquare(parts[1]).getPieceType().equals("p"))){
//						PassantTrack.setEnpassant();
//						PassantTrack=null;
//					}
//					b.printBoard();
//					whiteTurn=!whiteTurn;
//				}
//				else {
//					System.out.println("illegal move,try again3");
//				}
//					
//				input=scn.nextLine();
//				parts=input.split(" ");
//			}

	}
}
