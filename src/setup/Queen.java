package setup;

public class Queen extends Piece {

    public Queen(String color) {
        super(color);
        type="queen";
        // TODO Auto-generated constructor stub
    }
    String location;

    @Override
    public boolean isValidMove(String start,String input, Board board) {
    	int start_file = start.charAt(0) - 'a';
        int dest_file = input.charAt(0) - 'a';
        int start_rank= Movement.getRank(Integer.parseInt(start.charAt(1)+""));
        int dest_rank= Movement.getRank(Integer.parseInt(input.charAt(1)+""));
        Square[][] b = board.getBoard();  
        int file_diff=start_file-dest_file;
        int rank_diff=start_rank-dest_rank;
        
        if(this.isWhite==true && (b[dest_rank][dest_file].getPiece()==null || b[dest_rank][dest_file].getPieceColor().equals("b"))) {
	        if(file_diff==0 && !(Movement.hasPiecesInBetween(start, input, board))) {
	        	return true;
	        }
	        else if(rank_diff==0 && !(Movement.hasPiecesInBetween(start, input, board))) {
	        	return true;
	        }
	        else if(Math.abs(rank_diff)==Math.abs(file_diff) && !(Movement.hasPiecesInBetween(start,input,board))) {
	        	return true;
	        }
        }
        else if((b[dest_rank][dest_file].getPiece()==null || b[dest_rank][dest_file].getPieceColor().equals("w"))) {
        	if(file_diff==0 && !(Movement.hasPiecesInBetween(start, input, board))) {
	        	return true;
	        }
	        else if(rank_diff==0 && !(Movement.hasPiecesInBetween(start, input, board))) {
	        	return true;
	        }
	        else if(Math.abs(rank_diff)==Math.abs(file_diff) && !(Movement.hasPiecesInBetween(start,input,board))) {
	        	return true;
	        }
        }
    	
        return false;
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
    
    public boolean inCheck(Board board){
    	Square b[][] = board.getBoard();
    	return false;
    }
}