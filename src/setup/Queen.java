package setup;

public class Queen extends Piece {

    public Queen(String color) {
        super(color);
        type="queen";
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValidMove(String start,String input, Board board) {
    	String s=start.charAt(1)+"";
    	String e=input.charAt(1)+"";
    	int startX=board.getX(start.charAt(0));
    	int startY=board.getY(Integer.parseInt(s));
    	int endX=board.getX(input.charAt(0));
    	int endY=board.getY(Integer.parseInt(e));
    	Square startPos=board.getSquare(start);
    	Square inQuestion=board.getSquare(input);
    	if(!(inQuestion.getPieceType().equals(""))){
    		if(this.isWhite==true && inQuestion.getPieceColor().equals("w")) {
    			return false;
    		}
    		else if(this.isWhite==false && inQuestion.getPieceColor().equals("b")) {
    			return false;
    		}
    	}
    	return surroundCheck(startX,startY, endX, endY);
    }

    @Override
    public void move(String start, String end, Board board) {
    	this.moved();
        board.getSquare(end).setPiece(this);
        board.getSquare(start).setPiece(null);
    }
    
    public boolean surroundCheck(int startX, int startY,int endX,int endY){
    	for(int i=startY-1;i<=startY+1;i++) {
    		for(int j=startX-1;j<=startX+1;j++) {
    			if((endX==j && endY==i) && (i!=startY && j!=startX)) {
    				return true;
    			}
    		}
    	}
    	
    	return false ;
    }
    
    public boolean inCheck(String pos,Board board){
    	return false;
    }
}