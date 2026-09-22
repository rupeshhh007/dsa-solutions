import java.util.*;

class Solution {
    public int numDistinctIslands(int[][] grid) {

        HashSet<String> set = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    StringBuilder shape = new StringBuilder();

                    dfs(grid, i, j, i, j, shape);

                    set.add(shape.toString());
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] grid,
                     int row,
                     int col,
                     int baseRow,
                     int baseCol,
                     StringBuilder shape) {

        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        shape.append(row - baseRow)
             .append(",")
             .append(col - baseCol)
             .append(";");

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : dirs) {

            int newR = row + dir[0];
            int newC = col + dir[1];

            dfs(grid, newR, newC, baseRow, baseCol, shape);
        }
    }
}