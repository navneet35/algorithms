package com.algorithms.backtracking;

import java.util.Arrays;
/* Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 * 
 * Input : mat[][] = {{1, 1, 0, 0, 0},
 *                    {0, 1, 0, 0, 1},
 *                    {1, 0, 0, 1, 1},
 *                    {0, 0, 0, 0, 0},
 *                    {1, 0, 1, 0, 1} 
 * Output : 5
 * http://www.geeksforgeeks.org/find-number-of-islands/
 */

public class IslandCount {
	
	static boolean isSafe(int[][] mat, int[][] visited, int row, int col, int i, int j){
		return ((i >= 0 && i< row) && (j>= 0 && j < col) && mat[i][j] == 1 && visited[i][j] == 0);
	}
	
	static void dfsCount(int[][] mat, int[][] visited, int row, int col, int i, int j){
		visited[i][j] = -1;
		
		int[] r = {0, 0, -1, -1, -1, 1, 1, 1};
		int[] c = {-1, 1, -1, 1, 0, -1 , 1, 0};

		for(int k = 0; k < 8; k++)
//			System.out.println("i = " + (i + r[k]) + ", j = " + (j + c[k]));
			if(isSafe(mat, visited, row, col, i + r[k], j + c[k]))
				dfsCount(mat, visited, row, col, i + r[k], j + c[k]);
	}
	
	static int coundIslands(int[][] mat, int[][] visited){
		int count = 0;
		int row = mat.length;
		int col = mat[0].length;
		
		for(int i=0; i< row; i++){
			for(int j = 0; j< col; j++){
				if(mat[i][j] == 1 && visited[i][j] == 0){
					visited[i][j] = -1;
					dfsCount(mat, visited, row, col, i, j);
					count++;
				}
					
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[][] mat = {{1, 1, 0, 0, 0},
                	   {0, 1, 0, 0, 1},
                       {1, 0, 0, 1, 1},
                       {0, 0, 0, 0, 0},
                       {1, 0, 1, 0, 1}};
		
		int[][] visited = new int[mat.length][mat[0].length];
		for(int[] v : visited)
			Arrays.fill(v, 0);
		System.out.println(coundIslands(mat, visited));
	}

}
