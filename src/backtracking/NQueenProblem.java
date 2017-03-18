package backtracking;

public class NQueenProblem {
	
	private boolean isSafe(int[][] board, int row, int col, int N){
		
		//check for row
		for(int i = 0;i < N; i++)
			if(board[row][i] == 1)
				return false;
		
		//check for upper diagonal on left side
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if(board[i][j] == 1)
				return false;
		//check for lower diagonal
		for(int i = row, j = col; i < N && j >= 0; i++, j--)
			if(board[i][j] == 1)
				return false;
		
		return true;
	}
	
	private boolean solveNQueenUtil(int[][] board, int col, int N){
		if(col >= N)
			return true;
		
		for(int i = 0;i < N;i++){
			if(isSafe(board, i, col, N)){
				board[i][col] = 1;
				if(solveNQueenUtil(board, col + 1, N))
					return true;
				board[i][col] = 0;
			}
		}
		
		return false;
	}
	
	private void solveNQ(){
		int[][] board = {{0, 0, 0, 0},
						 {0, 0, 0, 0},
						 {0, 0, 0, 0},
						 {0, 0, 0, 0}
						};
		
		int N = board[0].length;
		
		if(solveNQueenUtil(board, 0, N) == false)
			System.out.println("Queens cannot be placed.");
		else{
			System.out.println("Queens have been placed successfully.");
			for(int i=0; i< N; i++){
				for(int j=0; j< N; j++)
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
		}
			
		
	}
	
	public static void main(String[] args) {
		NQueenProblem nqp = new NQueenProblem();
		nqp.solveNQ();
	}

}
