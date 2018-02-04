package nQueensProblem;

public class NqueensProblem {

	final static int N=4;
	
	public static boolean solveN_Queen(){
		int[][] chessBoard={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		if(FindSolution(chessBoard,0)==false){
			System.out.println("Does Not Exists");
			return false;
		}
		printSolution(chessBoard);
		return true;
	}
	
	public static boolean FindSolution(int[][] chessBoard,int pos){
		
		if(pos==N){
			return true;
		}
		
		for (int i = 0; i < N; i++) {
				if(checkIfPlaceable(chessBoard, i, pos))
				{
					chessBoard[i][pos]=1;
					if(FindSolution(chessBoard, pos+1)==true)
						return true;
				
					chessBoard[i][pos]=0;
				}
		}
		return false;
		
	}
	
	public static boolean checkIfPlaceable(int[][] chessBoard,int row,int col){
		int i,j;
		for (j = 0; j < col; j++) {
			if(chessBoard[row][j]==1)
				return false;
		}
		
		for (i=row, j=col; i>=0 && j>=0; i--, j--) {
				if(chessBoard[i][j]==1)
					return false;
		}
		
		for (i=row;  row<N; row++) {
			for (j=col; j>=0; j--) {
				if(chessBoard[i][j]==1)
				return false;
			}
		}
		
		return true;
	}
	
	public static void printSolution(int[][] chessBoard){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(chessBoard[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		solveN_Queen();
	}
	
}
