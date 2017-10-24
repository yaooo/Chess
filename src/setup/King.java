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
    public void move(String start, String end, Board board) {
        // TODO Auto-generated method stub
    }

}