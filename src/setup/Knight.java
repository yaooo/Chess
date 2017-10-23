package setup;

public class Knight extends Piece {

    public Knight(String color) {
        super(color);
        type="knight";
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