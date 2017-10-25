package setup;

public class King extends Piece {

    public King(String color) {
        super(color);
        type="king";
    }
    @Override
    public boolean isValidMove(String start,String input, Board board) {

        int start_file = start.charAt(0) - 'a';
        int dest_file = input.charAt(0) - 'a';
        int start_rank=getRank(Integer.parseInt(start.charAt(1)+""));
        int dest_rank=getRank(Integer.parseInt(input.charAt(1)+""));

        Square[][] b = board.getBoard();    //board is 8x8 matrix
        int diff_rank = dest_rank - start_rank;
        int diff_file = dest_file - start_file;

        //TODO: Check for king's special move, has moved piece cannot do it
        if(!this.hasMoved() && Math.abs(diff_rank) == 2 && dest_file == 0){
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

        if(start_file < 0 || start_file > 7 || dest_file < 0 || dest_file > 7)
            return false;

        if(dest_rank < 0 || start_rank > 7 || dest_rank < 0 || dest_rank > 7)
            return false;

        Square startPos = board.getSquare(start);
        Square endPos = board.getSquare(input);

        // Check nearby squares
        if(endPos.getPieceType() != null) {
            // King cannot eat his own people
            if (startPos.getPieceColor().equals("w")) {
                if (endPos.getPieceColor().equals("w"))
                    return false;
            } else if (startPos.getPieceColor().equals("b")) {
                if (endPos.getPieceColor().equals("b"))
                    return false;
            }
        }
        return true;
    }

    @Override
    public void move(String startKingPos, String endKingPos, Board board) {
        int start_file = startKingPos.charAt(0) - 'a';
        int dest_file = endKingPos.charAt(0) - 'a';
        int start_rank=getRank(Integer.parseInt(startKingPos.charAt(1)+""));
        int dest_rank=getRank(Integer.parseInt(endKingPos.charAt(1)+""));

        if(isValidMove(startKingPos,endKingPos, board)){
            if(Math.abs(start_rank - dest_rank) <= 1) {
                board.getSquare(startKingPos).setPiece(null);
                board.getSquare(endKingPos).setPiece(this);
            }

            //TODO: the case of castling
            //TODO: call castling(String startKingPos, String endKingPos, Board board)
        }
    }

    /**
     * Do castling for king and return the board
     * @param startKingPos  where the king starts
     * @param endKingPos    where the king ends
     * @param board The chessboard
     * @return The updated chessboard
     */
    public Square[][] castling(String startKingPos, String endKingPos, Board board) {
        int start_file = startKingPos.charAt(0) - 'a';
        int dest_file = endKingPos.charAt(0) - 'a';
        int start_rank=getRank(Integer.parseInt(startKingPos.charAt(1)+""));
        int dest_rank=getRank(Integer.parseInt(endKingPos.charAt(1)+""));

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

        //TODO: test it if it's right when set the board member to "NULL"
        b[rook_dest_rank][rook_dest_file] = b[rook_ini_rank][rook_ini_file];
        b[rook_ini_rank][rook_ini_file] = null;

        b[dest_rank][dest_file] = b[start_rank][start_file];
        b[start_rank][start_file] = null;

        return b;
    }

    private int getRank(int j) {
        int q=99;
        switch(j) {
            case 8:
                q=0;
                break;
            case 7:
                q=1;
                break;
            case 6:
                q=2;
                break;
            case 5:
                q=3;
                break;
            case 4:
                q=4;
                break;
            case 3:
                q=5;
                break;
            case 2:
                q=6;
                break;
            case 1:
                q=7;
                break;
            default:
                q=-1;
        }
        return q;
    }
}