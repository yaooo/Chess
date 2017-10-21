package setup;

public class Pawn extends Piece  {
	public Pawn(String color){
		super(color);
		type="pawn";
	}
	@Override
	public boolean isValidMove(String input, Square[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Square[][] move(String input, Square[][] board) {
		// TODO Auto-generated method stub
		return null;
	}

}
