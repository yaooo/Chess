package setup;

public class King extends Piece {

    public King(String color) {
        super(color);
        type="king";
        if(this.isWhite){
        	kingPos="e1";
        }
        else {
        	kingPos="e8";
        }
    }
    public String kingPos;
    @Override
    public boolean isValidMove(String start,String input, Board board) {

        int start_file = start.charAt(0) - 'a';
        int dest_file = input.charAt(0) - 'a';
        int start_rank= Movement.getRank(Integer.parseInt(start.charAt(1)+""));
        int dest_rank= Movement.getRank(Integer.parseInt(input.charAt(1)+""));

        Square[][] b = board.getBoard();    //board is 8x8 matrix
        int diff_rank = dest_rank - start_rank;
        int diff_file = dest_file - start_file;

        //TODO: Check for king's special move, has moved piece cannot do it
        if(!this.hasMoved() && Math.abs(diff_file) == 2 && diff_rank == 0){
            boolean hasPiecesInBetween = true;
            Piece rook = null;
            switch (input){
                case "c8":
                    hasPiecesInBetween = Movement.hasPiecesInBetween(start, "a8", board);
                    rook = board.getSquare("a8").getPiece();

                    if(rook != null){
                        return(!hasPiecesInBetween && !rook.hasMoved());
                    }else
                        return false;

                case "g8":
                    hasPiecesInBetween = Movement.hasPiecesInBetween(start, "h8", board);
                    rook = board.getSquare("h8").getPiece();

                    if(rook != null){
                        return(!hasPiecesInBetween && !rook.hasMoved());
                    }else
                        return false;
                case "c1":
                    hasPiecesInBetween = Movement.hasPiecesInBetween(start, "a1", board);
                    rook = board.getSquare("a1").getPiece();

                    if(rook != null){
                        return(!hasPiecesInBetween && !rook.hasMoved());
                    }else
                        return false;
                case "g1":
                    hasPiecesInBetween = Movement.hasPiecesInBetween(start, "h1", board);
                    rook = board.getSquare("h1").getPiece();

                    if(rook != null){
                        return(!hasPiecesInBetween && !rook.hasMoved());
                    }else
                        return false;
            }
        }


        // Check the input parameters
        if(start.equals(input))
            return false;

        if(Math.abs(diff_file) > 1 || Math.abs(diff_rank) > 1) 
            return false;

        if(start_file < 0 || start_file > 7 || dest_file < 0 || dest_file > 7) {
        	System.out.println("hello");
        	return false;
        }

        if(dest_rank < 0 || start_rank > 7 || dest_rank < 0 || dest_rank > 7) {
        	System.out.println("hello2");
        	return false;
        }

        Square startPos = board.getSquare(start);
        Square endPos = board.getSquare(input);

        // Check nearby squares
        if(endPos.getPieceType() != null) {
            // King cannot eat his own people
            if (startPos.getPieceColor().equals("w")) {
                if (endPos.getPieceColor().equals("w")) {
                	System.out.println("hello3");
                	return false;
                }
            } else if (startPos.getPieceColor().equals("b")) {
                if (endPos.getPieceColor().equals("b")){
                	System.out.println("hello4");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void move(String startKingPos, String endKingPos, Board board) {
        int start_file = startKingPos.charAt(0) - 'a';
        int dest_file = endKingPos.charAt(0) - 'a';
        int start_rank= Movement.getRank(Integer.parseInt(startKingPos.charAt(1)+""));
        int dest_rank= Movement.getRank(Integer.parseInt(endKingPos.charAt(1)+""));

        if(isValidMove(startKingPos,endKingPos, board)){
            this.moved();

            if(Math.abs(start_file - dest_file) <= 1) {
                board.getSquare(endKingPos).setPiece(this);
                board.getSquare(startKingPos).setPiece(null);
            }else{
                board.setBoard(castling(startKingPos, endKingPos, board));
            }

        }else{
            System.out.println("Non-valid move");
        }
        kingPos=endKingPos;
    }

    /**
     * Do castling for king and return the board
     * @param startKingPos  where the king starts
     * @param endKingPos    where the king ends
     * @param board The chessboard
     * @return The updated chessboard
     */
    private Square[][] castling(String startKingPos, String endKingPos, Board board) {
        int start_file = startKingPos.charAt(0) - 'a';
        int dest_file = endKingPos.charAt(0) - 'a';
        int start_rank= Movement.getRank(Integer.parseInt(startKingPos.charAt(1)+""));
        int dest_rank= Movement.getRank(Integer.parseInt(endKingPos.charAt(1)+""));

        int rook_ini_file = start_file; //will be replaced anyway
        int rook_dest_file = dest_file; //will be replaced anyway
        int rook_ini_rank = start_rank;
        int rook_dest_rank = start_rank;

        if(dest_file == 2){
            rook_ini_file = 0;
            rook_dest_file = 3;
        }else if(dest_file == 6){
            rook_ini_file = 7;
            rook_dest_file = 5;
        }

        Square[][] b = board.getBoard();

        Piece rook = b[rook_ini_rank][rook_ini_file].getPiece();
        Piece king = b[start_rank][start_file].getPiece();

        b[rook_dest_rank][rook_dest_file].setPiece(rook);
        b[rook_ini_rank][rook_ini_file].setPiece(null);

        b[dest_rank][dest_file].setPiece(king);
        b[start_rank][start_file].setPiece(null);

        System.out.println("NEED to do castling");
        return b;
    }

    
    
    public boolean inCheck(Board board) {
    	Square b[][]=board.getBoard();
    	boolean check=false;
    	for(int i=0;i<8;i++) {
    		for(int j=0;j<8;j++){
    			if(b[i][j].getPiece()!=null && this.isWhite() && !(b[i][j].getPiece().isWhite())){
    				String h = reverseN(i,j);
    				if(board.getSquare(h).getPiece().isValidMove(h, kingPos, board)) {
    					check=true;
    				}
    				
    			}
    			else if(b[i][j].getPiece()!=null && this.isWhite() && b[i][j].getPiece().isWhite()) {
    				String h = reverseN(i,j);
    				if(board.getSquare(h).getPiece().isValidMove(h, kingPos, board)) {
    					check=true;
    				}
    			}
    				
    		}
    	}
    	return check;
    }
    
    public boolean checkMate(Board board) {
    	Square b[][]=board.getBoard();
    	int start_file = kingPos.charAt(0) - 'a';
    	int start_rank= Movement.getRank(Integer.parseInt(kingPos.charAt(1)+""));
    	boolean cMate=false;
    	cMate=b[start_file][start_rank].getPiece().inCheck(board);
    	if(cMate==false) {
    		return cMate;
    	}
    	for(int i=start_rank-1;i<=start_rank+1;i++) {
    		for(int j=start_file;j<start_file+1;j++) {
    			if((i>7 || i<0) || (j>7 ||j<0)){
    			}
	    		else if(b[i][j].getPiece()==null) {
	    			b[i][j].setPiece(this);
	    			b[start_file][start_rank].setPiece(null);
	    			cMate=(cMate && b[i][j].getPiece().inCheck(board));
	    			b[start_file][start_rank].setPiece(this);
	    			b[i][j].setPiece(null);
	    		}
    		}
    	}
    	return cMate;
    }
    
    private String reverseN(int k, int q) {
    	String rank="";
    	String file="";
		switch(k) {
		case 0:
			rank="8";
			break;
		case 1:
			rank="7";
			break;
		case 2:
			rank="6";
			break;
		case 3:
			rank="5";
			break;
		case 4:
			rank="4";
			break;
		case 5:
			rank="3";
			break;
		case 6:
			rank="2";
			break;
		case 7:
			rank="1";
			break;
		default:
			rank="-1";
		}
		
		switch(q) {
		case 0:
			file="a";
			break;
		case 1:
			file="b";
			break;
		case 2:
			file="c";
			break;
		case 3:
			file="d";
			break;
		case 4:
			file="e";
			break;
		case 5:
			file="f";
			break;
		case 6:
			file="g";
			break;
		case 7:
			file="h";
			break;
		default:
			file="-1";
		}
		return file+rank;
    	
    }
}