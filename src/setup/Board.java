package setup;

/**
 * @author Sagar Patel
 * @author Yao Shi
 * @version 1.0
 */


public class Board {

	private Square[][] board;

	public Board() {
		this.board = new Square[8][8];
	}
	public void initBoard() {
		int whiteTile=0;
		for(int i=0;i<2;i++) {
			for(int j=0;j<board[i].length;j++) {
				if((j==0 || j==7) && i==0 ) {
					Rook temp = new Rook("black");
					if(j==0){
						board[i][j]=new Square(temp,"white");
					}
					else {
						board[i][j]=new Square(temp,"black");
					}
				}
				else if((j==1 || j==6) && i==0){
					Knight temp = new Knight("black");
					if(j==1) {
						board[i][j]=new Square(temp,"black");
					}
					else {
						board[i][j]=new Square(temp,"white");
					}

				}
				else if((j==2 || j==5) && i==0){
					Bishop temp = new Bishop("black");
					if(j==2) {
						board[i][j]=new Square(temp,"white");
					}
					else {
						board[i][j]=new Square(temp,"black");
					}

				}
				else if(i==0 && (j==3)) {
					Queen temp = new Queen("black");
					board[i][j]=new Square(temp,"black");
				}
				else if( i==0 && j==4) {
					King temp =new King ("black");
					board[i][j]=new Square(temp,"white");
				}
				else if(i==1) {
					Pawn temp = new Pawn("black");
					if(j%2==0) {
						board[i][j]=new Square(temp,"black");
					}
					else {
						board[i][j]=new Square(temp,"white");
					}
				}
			}
		}
		for(int i=2;i<board.length-2;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(whiteTile==0){
					board[i][j]= new Square("white");
					whiteTile=1;
				}
				else {
					board[i][j]=new Square("black");
					whiteTile=0;
				}
			}
			if(whiteTile==0) {
				whiteTile=1;
			}
			else if(whiteTile==1) {
				whiteTile=0;
			}
		}
		for(int i=6;i<8;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(i==7 && (j==0 || j==7)) {
					Rook temp = new Rook ("white");
					if(j==0) {
						board[i][j]=new Square(temp,"black");
					}
					else {
						board[i][j]=new Square(temp,"white");
					}
				}
				else if(i==7 && (j==1 || j==6)) {
					Knight temp = new Knight("white");
					if(j==1) {
						board[i][j]=new Square(temp,"white");
					}
					else {
						board[i][j]=new Square(temp,"black");
					}
				}
				else if(i==7 && (j==2 ||j==5)) {
					Bishop temp = new Bishop("white");
					if(j==2) {
						board[i][j]=new Square(temp,"black");
					}
					else {
						board[i][j]=new Square(temp,"white");
					}
				}
				else if(i==7 && j==3) {
					Queen temp = new Queen("white");
					board[i][j]= new Square(temp,"white");
				}
				else if(i==7 && j==4) {
					King temp = new King("black");
					board[i][j]= new Square(temp,"black");
				}
				else if(i==6) {
					Pawn temp = new Pawn("white");
					if(j%2==0){
						board[i][j]=new Square(temp,"white");
					}
					else{
						board[i][j]=new Square(temp,"black");
					}
				}
			}
		}
	}

	public void printBoard(){
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j].getPieceType()==null){
					if(board[i][j].isSquareBlack()==true){
						System.out.print("## ");
					}
					else {
						System.out.print("   ");
					}
				}
				else {
					System.out.print(board[i][j].toString()+" ");
				}
			}
			System.out.println("");
		}
	}
}