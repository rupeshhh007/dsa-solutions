class Solution {
    public int numberOfSets(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        long[][] sum = new long[n + 1][k + 1];
        int mod = 1_000_000_007;

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            sum[i][0] = i + 1;
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] = (dp[i - 1][j] + sum[i - 1][j - 1]) % mod;
                sum[i][j] = (sum[i - 1][j] + dp[i][j]) % mod;
            }
        }

        return (int) dp[n - 1][k];
    }
}
