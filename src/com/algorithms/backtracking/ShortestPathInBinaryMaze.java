package com.algorithms.backtracking;

/**
 * https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
 * */
import java.util.*;

/**
 * @author - navsinn
 * @date - Dec 16, 2018
 */
public class ShortestPathInBinaryMaze {
    static class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Dist{
        Cell cell;
        int val;

        Dist(Cell cell, int val) {
            this.cell = cell;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int mat[][] =
        {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };

        ShortestPathInBinaryMaze sp = new ShortestPathInBinaryMaze();
        System.out.println(shortestPath(mat, mat.length, mat[0].length, new Cell(0, 0), new Cell(3, 4)));
    }

    static boolean isValid(int[][] mat, int x, int y, int row, int col, Set<Cell> visited) {
        return(x >= 0 && x < row
                && y >= 0 && y < col
                && mat[x][y] == 1
                && !visited.contains(new Cell(x, y)));
    }

    static int shortestPath(int[][] mat, int row, int col, Cell src, Cell dest) {
        Queue<Dist> q = new LinkedList<>();
        Set<Cell> visited = new HashSet<>();
        q.offer(new Dist(src, 0));
        int rowNum[] = {-1, 0, 0, 1};
        int colNum[] = {0, -1, 1, 0};

        while(!q.isEmpty()) {
            Dist d = q.poll();
            visited.add(d.cell);
            if(d.cell.equals(dest))
                return d.val;

            for(int i =0; i < 4; i++) {
                int tempx = d.cell.x + rowNum[i];
                int tempy = d.cell.y + colNum[i];
                if(isValid(mat, tempx, tempy, row, col, visited)) {
                    Cell c = new Cell(tempx, tempy);
                    q.offer(new Dist(c, d.val + 1));
                }
            }
        }
        return -1;
    }
}
