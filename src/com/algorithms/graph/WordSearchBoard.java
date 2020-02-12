package com.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author - navsinn
 * @date - Nov 25, 2018
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
 * The same letter cell may be used more than once.
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * <p>
 * word = "ABCCED", -> returns 1,
 * word = "SEE", -> returns 1,
 * word = "ABCB", -> returns 1,
 * word = "ABFSAB" -> returns 1
 * word = "ABCD" -> returns 0
 */
public class WordSearchBoard {
    public static void main(String[] args) {
        char[][] board = {
                {'a', 'a'},
        };
        String word = "aaa";
        WordSearchBoard wsb = new WordSearchBoard();
        System.out.println(wsb.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if(word.length() == 1 && word.charAt(0) == board[0][0])
            return true;

        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
        for(int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], 0);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0 && word.charAt(0) == board[i][j]) {
                    visited[i][j] = 1;
                    if (existsUtil(board, i, j, word, 1, visited))
                        return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

    public boolean existsUtil(char[][] board, int row, int col, String word, int index, int[][] visited) {
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        if (index == word.length())
            return true;
        visited[row][col] = 1;
        for (int p = 0; p < 4; p++) {
            int xMar = row + x[p];
            int yMar = col + y[p];
            if (isAdjacent(xMar, yMar, board.length, board[0].length, visited, board, word.charAt(index))
                    && existsUtil(board, xMar, yMar, word, index + 1, visited))
                 return true;
        }
        visited[row][col] = 0;
        return false;
    }

    public boolean isAdjacent(int rowIndex, int colIndex, int row, int col, int[][] visited, char[][] board, char wordChar) {
        return (rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col
                && visited[rowIndex][colIndex] == 0
                && board[rowIndex][colIndex] == wordChar);
    }


}
