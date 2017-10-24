package setup;

public class Pawn extends Piece{
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
    	int endX=board.getX(input.charAt(0));
    	int endY=board.getY(Integer.parseInt(e));
    	Square startPos=board.getSquare(start);
    	Square inQuestion=board.getSquare(input);
    	Movement m = new Movement();
    	if(inQuestion==null) {
    		return false;
    	}
    	if(startPos.getPieceColor().equals("w")) {
        	if(endY==startY-1 && (endX==startX-1 || endX==startX+1) && !(inQuestion.getPieceType()=="")) {
        		return true;
            }
        	else if(!hasMoved && (endY==startY-1 || endY==startY-2) && inQuestion.getPiece()==null && !(m.hasPiecesInBetween(start, input, board))) {
        		return true;
        	}
        }
        else if(startPos.getPieceColor().equals("b")) {
        	if(endY==startY+1 && (endX==startX-1 || endX==startX+1) && !(inQuestion.getPiece()==null)) {
        		return true;
            }
        	else if(!hasMoved && (endY==startY+1 || endY==startY+2) && inQuestion.getPiece()==null && !(m.hasPiecesInBetween(start, input, board))) {
        		return true;
        	}
        	
        }
        return false;
    }

    @Override
    public void move(String start ,String end, Board board) {
    	board.getSquare(start).setPiece(null);
		board.getSquare(end).setPiece(this);
    }
    
}