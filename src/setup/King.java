package setup;

public class King extends Piece {

    public King(String color) {
        super(color);
        type="king";
    }
    @Override
    public boolean isValidMove(String start,String input, Board board) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Square[][] move(String input, Square[][] board) {
        // TODO Auto-generated method stub
        return null;
    }

}