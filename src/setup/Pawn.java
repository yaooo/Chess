package setup;

public class Pawn extends Piece  {
    public Pawn(String color){
        super(color);
        type="pawn";
    }
    @Override
    public boolean isValidMove(String start, String input, Board board) {
    	String s=start.charAt(1)+"";
    	String e=input.charAt(1)+"";
    	int startX=board.getX(start.charAt(0));
    	int startY=board.getY(Integer.parseInt(s));
    	int endX=board.getX(start.charAt(0));
    	int endY=board.getY(Integer.parseInt(e));
    	Square startPos=board.getSquare(start);
    	Square inQuestion=board.getSquare(input);
        if(!hasMoved && startPos.getPieceColor().equals("w")) {
        	if((endY==startY-1 || endY==startY-2) && inQuestion.getPiece()==null) {
        			return true;
        	}
        }
        else if(!hasMoved && startPos.getPieceColor().equals("b")) {
        	if((endY==startY+1 || endY==startY+2) && inQuestion.getPiece()==null) {
        			System.out.println("valid move");
        			return true;
        	}
        }
        return false;
    }

    @Override
    public Square[][] move(String input, Square[][] board) {
        
        return null;
    }
    
}