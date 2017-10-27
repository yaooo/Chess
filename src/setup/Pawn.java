package setup;

public class Pawn extends Piece{
    public Pawn(String color){
        super(color);
        type="pawn";
        EnPassant=false;
    }
    public boolean EnPassant;
    @Override
    public boolean isValidMove(String start, String input, Board board) {
    	 int start_file = start.charAt(0) - 'a';
         int dest_file = input.charAt(0) - 'a';
         int start_rank= Movement.getRank(Integer.parseInt(start.charAt(1)+""));
         int dest_rank= Movement.getRank(Integer.parseInt(input.charAt(1)+""));
         Square[][] b = board.getBoard();  
         
         
         if(this.isWhite()) {
	         if(hasMoved==false && dest_rank==start_rank-2 && b[dest_rank][dest_file].getPiece()==null && !(Movement.hasPiecesInBetween(start, input, board))) {
	        	 EnPassant=true;
	        	 return true;
	         }
	         else if(dest_rank==start_rank-1 && 
	        		 dest_file==start_file-1 && 
	        		 b[dest_rank][dest_file].getPiece()==null && 
	        		 !(b[start_rank][start_file-1].getPiece()==null) &&
	        		 b[start_rank][start_file-1].getPieceType().equals("p") && 
	        		 b[start_rank][start_file-1].getPiece().isWhite()==false &&  
	        		 b[start_rank][start_file-1].getPiece().getEnpassant()==true) {
	        	 	
	        	 b[start_rank][start_file-1].setPiece(null);
	        	 board.setBoard(b);
	        	 return true;
	         }
	         else if(dest_rank==start_rank-1 && 
	        		 dest_file==start_file+1 && 
	        		 b[dest_rank][dest_file].getPiece()==null && 
	        	     !(b[start_rank][start_file+1].getPiece()==null) &&
	        		 b[start_rank][start_file+1].getPieceType().equals("p") && 
	        		 b[start_rank][start_file+1].getPiece().isWhite()==false &&  
	        		 b[start_rank][start_file+1].getPiece().getEnpassant()==true) {
	        	 	
	        	 b[start_rank][start_file+1].setPiece(null);
	        	 board.setBoard(b);
	        	 return true;
	         }
	         else if(dest_rank==start_rank-1 && (dest_file==start_file-1 || dest_file==start_file+1) && b[dest_rank][dest_file].getPiece()!=null && b[dest_rank][dest_file].getPieceColor().equals("b") ) {
	        	 return true;
	         }
	         else if(dest_rank==start_rank-1 && b[dest_rank][dest_file].getPiece()==null) {
	        	 return true;
	         }
         }
         else {
        	 if(hasMoved==false && dest_rank==start_rank+2 && b[dest_rank][dest_file].getPiece()==null && !(Movement.hasPiecesInBetween(start, input, board))) {
        		 EnPassant=true;
	        	 return true;
	         }
        	 else if(dest_rank==start_rank+1 && 
	        		 dest_file==start_file-1 && 
	        		 b[dest_rank][dest_file].getPiece()==null && 
	        				 !(b[start_rank][start_file-1].getPiece()==null) &&
	        		 b[start_rank][start_file-1].getPieceType().equals("p") && 
	        		 b[start_rank][start_file-1].getPiece().isWhite()==true &&  
	        		 b[start_rank][start_file-1].getPiece().getEnpassant()==true) {
	        	 	
	        	 b[start_rank][start_file-1].setPiece(null);
	        	 board.setBoard(b);
	        	 return true;
	         }
        	 else if(dest_rank==start_rank+1 && 
	        		 dest_file==start_file+1 && 
	        		 b[dest_rank][dest_file].getPiece()==null && 
	        		 !(b[start_rank][start_file+1].getPiece()==null) &&
	        		 b[start_rank][start_file+1].getPieceType().equals("p") && 
	        		 b[start_rank][start_file+1].getPiece().isWhite()==true &&  
	        		 b[start_rank][start_file+1].getPiece().getEnpassant()==true) {
	        	 	
	        	 b[start_rank][start_file+1].setPiece(null);
	        	 board.setBoard(b);
	        	 return true;
	         }
        	 else if(dest_rank==start_rank+1 && (dest_file==start_file-1 || dest_file==start_file+1) && b[dest_rank][dest_file].getPiece()!=null && b[dest_rank][dest_file].getPieceColor().equals("w") ) {
	        	 return true;
	         }
	         else if(dest_rank==start_rank+1 && b[dest_rank][dest_file].getPiece()==null) {
	        	 return true;
	         }
         }
         
         return false;
    }

    @Override
    public void move(String start ,String end, Board board) {
		board.getSquare(end).setPiece(this);
		board.getSquare(start).setPiece(null);
		int endY=board.getY(Integer.parseInt(end.charAt(1)+""));
		if(hasMoved==false) {
			hasMoved=true;
		}
		if(this.isWhite() && endY==0) {
			Queen Promotion = new Queen("white");
			board.getSquare(end).setPiece(Promotion);;
			
		}
		else if(!(this.isWhite()) && endY==7){
			Queen Promotion = new Queen("black");
			board.getSquare(end).setPiece(Promotion);
			
		}
    }
    public boolean getEnpassant() {
    	return EnPassant;
    }
    public void setEnpassant() {
    	EnPassant=false;
    }


}