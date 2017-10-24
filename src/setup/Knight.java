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
    public void move(String start, String end, Board board) {
        // TODO Auto-generated method stub
    }

}