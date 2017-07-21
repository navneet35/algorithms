package com.algorithms.backtracking;

public class RatInAMaze {
	private static int ROW_SIZE = 4;
	private static int COL_SIZE = 4;
	private static int VALID_STEP = 1;
	
	static boolean isSafe(int[][] maze, int x, int y){
		return (x > -1 && x < ROW_SIZE) && (y > -1 && y < COL_SIZE) && maze[x][y] == VALID_STEP;
	}
	
	static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol){
		if(x == ROW_SIZE-1 && y == COL_SIZE-1){
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze, x, y)){
			sol[x][y] = 1;
			
			if(solveMazeUtil(maze, x+1, y, sol))
				return true;
			if(solveMazeUtil(maze, x, y+1, sol))
				return true;
			
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
	
	static void solveMaze(int[][] maze){
		int[][] sol = new int[ROW_SIZE][COL_SIZE];
		if(solveMazeUtil(maze, 0, 0, sol))
			for(int i=0; i<ROW_SIZE; i++){
				for(int j=0; j<COL_SIZE; j++)
					System.out.print(sol[i][j] + " ");
				System.out.println();
			}
	}	
	
	public static void main(String[] args) {
		int[][] maze  =  { 
				{1, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}
		    };
		 
		    solveMaze(maze);
	}

}
