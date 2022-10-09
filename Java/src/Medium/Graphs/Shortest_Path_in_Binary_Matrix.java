package Medium.Graphs;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
*/

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Cell> q = new LinkedList<>();
        Cell c = new Cell(0,0, 1);
        q.add(c);
        visited[0][0] = true;
        while (!q.isEmpty()){
            Cell current = q.poll();
            if(current.row == grid.length-1 && current.column == grid[0].length-1)
                return current.cost;
            Cell[] directions = current.getDirections(grid);
            for(Cell cell : directions){
                if(cell != null && grid[cell.row][cell.column] == 0 && !visited[cell.row][cell.column]){
                    visited[cell.row][cell.column] = true;
                    q.add(cell);
                }
            }
        }
        return -1;
    }

}

class Cell{
    int row;
    int column;
    int cost;

    public Cell(int row, int column, int cost){
        this.row = row;
        this.column = column;
        this.cost = cost;
    }

    public Cell moveRight(int[][] grid){
        if(column+1 < grid[0].length)
            return new Cell(row, column+1, cost+1);
        return null;
    }

    public Cell moveLeft(int[][] grid){
        if(column-1 >= 0)
            return new Cell(row, column-1,cost+1);
        return null;
    }

    public Cell moveUp(int[][] grid){
        if(row-1 >= 0)
            return new Cell(row-1, column, cost+1);
        return null;
    }

    public Cell moveDown(int[][] grid){
        if(row+1 < grid.length)
            return new Cell(row+1, column, cost+1);
        return null;
    }

    public Cell moveDownRight(int[][] grid){
        if(this.moveDown(grid) != null && this.moveRight(grid) != null)
            return new Cell(row+1, column+1, cost+1);
        return null;
    }

    public Cell moveDownLeft(int[][] grid){
        if(this.moveDown(grid) != null && this.moveLeft(grid) != null)
            return new Cell(row+1, column-1, cost+1);
        return null;
    }

    public Cell moveUpLeft(int[][] grid){
        if(this.moveUp(grid) != null && this.moveLeft(grid) != null)
            return new Cell(row-1, column-1, cost+1);
        return null;
    }

    public Cell moveUpRight(int[][] grid){
        if(this.moveUp(grid) != null && this.moveRight(grid) != null)
            return new Cell(row-1, column+1, cost+1);
        return null;
    }

    public Cell[] getDirections(int[][] grid){
        Cell moveRight = moveRight(grid);
        Cell moveLeft = moveLeft(grid);
        Cell moveUp = moveUp(grid);
        Cell moveDown = moveDown(grid);
        Cell moveUpRight = moveUpRight(grid);
        Cell moveUpLeft = moveUpLeft(grid);
        Cell moveDownRight = moveDownRight(grid);
        Cell moveDownLeft = moveDownLeft(grid);
        Cell[] result = {moveRight, moveDown, moveLeft, moveUp, moveUpRight, moveUpLeft, moveDownLeft, moveDownRight};
        return result;
    }
}
