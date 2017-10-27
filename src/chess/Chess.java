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
			Scanner scn=new Scanner(System.in);
			b.initBoard();
			b.printBoard();
			String input;
			boolean whiteTurn=true;
			System.out.println("White player make your move.");
			input=scn.nextLine();
			String parts[]=input.split(" ");
			Pawn PassantTrack=null;
			while(!(parts[0].equals("resign"))){
				if(b.getSquare(parts[0]).getPieceColor().equals("w") && whiteTurn==false) {
					System.out.println("illegal move,try again");
				}
				else if(b.getSquare(parts[0]).getPieceColor().equals("b")&& whiteTurn==true) {
					System.out.println("illegal move,try again");
				}
				else if(b.getSquare(parts[0]).getPiece().isValidMove(parts[0], parts[1], b)) {
					b.getSquare(parts[0]).getPiece().move(parts[0],parts[1],b);
					if(b.getSquare(parts[1]).getPieceType().equals("p")){
						if(PassantTrack==null) {
							PassantTrack=(Pawn)b.getSquare(parts[1]).getPiece();
						}
						else{
							PassantTrack.setEnpassant();
							PassantTrack=(Pawn)b.getSquare(parts[1]).getPiece();
						}
					}
					else if(PassantTrack!=null && !(b.getSquare(parts[1]).getPieceType().equals("p"))){
						PassantTrack.setEnpassant();
						PassantTrack=null;
					}
					b.printBoard();
					whiteTurn=!whiteTurn;
				}
				else {
					System.out.println("illegal move,try again");
				}
					
				input=scn.nextLine();
				parts=input.split(" ");
			}

	}
}
