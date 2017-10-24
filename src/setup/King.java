package setup;

public class King extends Piece {

    public King(String color) {
        super(color);
        type="king";
    }
    @Override
    public boolean isValidMove(String start,String input, Board board) {

        // TODO King's special move



        int start_file = start.charAt(0) - 'a';
        int start_rank = start.charAt(1) - '1';
        int dest_file = input.charAt(0) - 'a';
        int dest_rank = input.charAt(1) - '1';

        Square[][] b = board.getBoard();    //board is 8x8 matrix
        int diff_rank = dest_rank - start_rank;
        int diff_file = dest_file - start_file;

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
    public void move(String start, String end, Board board) {
        board.getSquare(start).setPiece(null);
        board.getSquare(end).setPiece(this);
    }

    public Square[][] castling(String startKingPos, String endKingPos, Board board) {
        int start_file = startKingPos.charAt(0) - 'a';
        int start_rank = startKingPos.charAt(1) - '1';
        int dest_file = endKingPos.charAt(0) - 'a';
        int dest_rank = endKingPos.charAt(1) - '1';

        Square[][] b = board.getBoard();

        if(!this.hasMoved()){




        }


        //TODO: has moved piece cannot do it
        //TODO: Add this to the validation check

    }


}