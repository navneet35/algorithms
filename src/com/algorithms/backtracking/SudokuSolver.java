package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

  private int gridRowSize = 9; 
  private int gridColSize = 9;
  private int gridRow = 3; 
  private int gridCol = 3;
  private final int UNASSIGNED = 0;
  
  public int[][] grid = {
      {3, 0, 6, 5, 0, 8, 4, 0, 0},
      {5, 2, 0, 0, 0, 0, 0, 0, 0},
      {0, 8, 7, 0, 0, 0, 0, 3, 1},
      {0, 0, 3, 0, 1, 0, 0, 8, 0},
      {9, 0, 0, 8, 6, 3, 0, 0, 5},
      {0, 5, 0, 0, 9, 0, 6, 0, 0},
      {1, 3, 0, 0, 0, 0, 2, 5, 0},
      {0, 0, 0, 0, 0, 0, 0, 7, 4},
      {0, 0, 5, 2, 0, 6, 3, 0, 0}
      };
  
  public boolean solve(int[][] sudokuGrid){
     List<Integer> rowAndCol = findUnassgnedLocation(sudokuGrid);
     if(rowAndCol == null)
       return true;
     
     int row = rowAndCol.get(0);
     int col = rowAndCol.get(1);
     
     for(int i=1; i <= 9; i++){
       if(isSafe(sudokuGrid, row, col, i)){
         sudokuGrid[row][col] = i;
         if(solve(sudokuGrid))
           return true;
         sudokuGrid[row][col] = UNASSIGNED;
       }
     }
     
     return false;
  }
  
  private boolean isSafe(int[][] grid, int row, int col, int num){
    return uniqueInRow(grid, row, num) 
        && uniqueInCol(grid, col, num) 
        && uniqueInSubGrid(grid, row - row%gridRow, col - col%gridCol, num);
  }
  
  private boolean uniqueInRow(int[][] grid, int row, int num){
    for(int j=0; j < gridColSize; j++)
      if(grid[row][j] == num)
        return false;
    return true;
  }
  
  private boolean uniqueInCol(int[][] grid, int col, int num){
    for(int i=0; i < gridColSize; i++)
      if(grid[i][col] == num)
        return false;
    return true;
  }
  
  private boolean uniqueInSubGrid(int[][] grid, int row, int col, int num){
    for(int i=row; i < row + gridRow; i++){
      for(int j=col; j < col + gridCol; j++){
        if(grid[i][j] == num)
          return false;
      }
    }
    return true;
  }
  
  private List<Integer> findUnassgnedLocation(int[][] grid){
    List<Integer> rowAndCol = null;
    for(int i=0; i < gridRowSize; i++){
      for(int j=0; j< gridColSize; j++){
        if(grid[i][j] == UNASSIGNED){
          rowAndCol = new ArrayList<>(2);
          rowAndCol.add(i);
          rowAndCol.add(j);
          return rowAndCol;
        }
      }
    }
    
    return rowAndCol;
  }
  
  public void print(int[][] grid){
    for(int i=0;i < gridRowSize; i++){
      for(int j=0; j < gridColSize; j++){
        System.out.print(grid[i][j] + ", ");
      }
      
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    SudokuSolver ss = new SudokuSolver();
    if(ss.solve(ss.grid))
      ss.print(ss.grid);
    else
      System.out.println("Not Solvable");
  }

}
