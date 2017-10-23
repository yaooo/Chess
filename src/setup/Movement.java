package setup;

public class Movement {

	public static boolean hasPiecesInBetween(String start, String destination, Board chessBoard) {
        int start_file = start.charAt(0) - 'a';
        int start_rank = start.charAt(1) - '1';
        int dest_file = destination.charAt(0) - 'a';
        int dest_rank = destination.charAt(1) - '1';


        Square[][] board = chessBoard.getBoard();    //board is 8x8 matrix
        int diff_rank = dest_rank - start_rank;
        int diff_file = dest_file - start_file;

        if (start.equals(destination)) {

            //TODO: the piece does not move(invalid move)

        }


        System.out.println("start:" + start_rank + "dest rank:" + dest_rank);

        // if the files are the same
        if (start_file == dest_file) {
            if (dest_rank - start_rank < 0) {
                for (int i = start_rank - 1; i > dest_rank; i--) {
                    if (board[i][start_file].getPieceType() != null) {
                        return true;
                    }
                }
            } else if (dest_rank - start_rank > 0) {
                for (int i = start_rank + 1; i < dest_rank; i++) {
                    if (board[i][start_file].getPieceType() != null) {
                        return true;
                    }
                }

            }
        }


        // if the ranks are the same
        if (dest_rank == start_rank) {
            if (dest_file - start_file < 0) {
                for (int i = start_file - 1; i > dest_file ; i--) {
                    if (board[start_rank][i].getPieceType() != null)
                        System.out.print("file" + i);
                        return true;
                }
            } else if (dest_file - start_file > 0) {
                for (int i = start_file + 1; i < dest_file ; i++) {
                    if (board[start_rank][i].getPieceType() != null)
                        return true;
                }
            }
        }


            // check diagonally
        if (Math.abs(start_file - dest_file) == Math.abs(start_rank - dest_rank)) {


        }


        return false;

    }
}
