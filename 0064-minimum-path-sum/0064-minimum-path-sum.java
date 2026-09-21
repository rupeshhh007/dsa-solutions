class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } 
                else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } 
                else if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } 
                else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[n - 1];
    }
}