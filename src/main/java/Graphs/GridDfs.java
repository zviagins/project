package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class GridDfs {

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    class Cell {
        int row;
        int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    column == cell.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    public List<Integer> dfs(int[][] grid){
        List<Integer> result = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Stack<Cell> s = new Stack<>();
        Cell startPoint = new Cell(0,0);
        s.push(startPoint);

        while (!s.isEmpty()){
            Cell c = s.pop();
            visited[c.row][c.column] = true;
            result.add(grid[c.row][c.column]);
            for (Direction direction : Direction.values()) {
                if (validMove(c, direction, visited, grid)) {
                    s.push(move(c, direction));
                }
            }
        }

        return result;
    }

    private Cell move(Cell c, Direction direction) {
        switch (direction){
            case UP:
                return new Cell(c.row-1, c.column);
            case DOWN:
                return new Cell(c.row+1, c.column);
            case RIGHT:
                return new Cell(c.row, c.column+1);
            case LEFT:
                return new Cell(c.row, c.column-1);
        }
        return null;
    }

    private boolean validMove(Cell c, Direction direction, boolean[][] visited, int[][] grid) {
        switch (direction){
            case UP:
                if (c.row == 0 || grid[c.row-1][c.column] == 1 || visited[c.row-1][c.column] == true)
                    return false;
                break;
            case DOWN:
                if (c.row == grid.length || grid[c.row+1][c.column] == 1 || visited[c.row+1][c.column] == true)
                    return false;
                break;
            case RIGHT:
                if (c.column == grid[0].length || grid[c.row][c.column+1] == 1 || visited[c.row][c.column+1] == true)
                    return false;
                break;
            case LEFT:
                if (c.column == 0 || grid[c.row][c.column-1] == 1 || visited[c.row][c.column-1] == true)
                    return false;
                break;
        }
        return true;
    }

    public static void main(String[] args){

    }
}
