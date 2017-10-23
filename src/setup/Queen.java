package setup;

public class Queen extends Piece {

    public Queen(String color) {
        super(color);
        type="queen";
        // TODO Auto-generated constructor stub
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