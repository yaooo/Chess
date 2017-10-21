package setup;

public class Movement {

//	public static void main(String [] args) {
////		hasPiecesInbetween("c1", "c4");
//	}
	
	
	public static boolean hasPiecesInBetween(String start, String destination, Square[][] board) {
		char start_file = start.charAt(0);
		int start_rank = start.charAt(1) - '0';
		char dest_file = destination.charAt(0);
		int dest_rank = destination.charAt(1) - '0';
		
		int temp = dest_rank - start_rank;

		// check vertically
        if(start_file == dest_file){


        }

        // check horizontal
        if(dest_rank == start_rank){



        }


        // check diagonally
        if (Math.abs(start_file - dest_file) == Math.abs(start_rank - dest_rank)) {


        }
		
		
		
	
		return false;
	}
	
}
