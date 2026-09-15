class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        // palindrome DP
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                pal[i][j] =
                    s.charAt(i) == s.charAt(j)
                    &&
                    (j - i <= 2 || pal[i + 1][j - 1]);
            }
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // skip current character
            dp[i] = dp[i - 1];

            // palindrome of exactly length k
            if (i >= k && pal[i - k][i - 1]) {

                dp[i] = Math.max(
                    dp[i],
                    dp[i - k] + 1
                );
            }

            // palindrome of exactly length k + 1
            if (i >= k + 1 && pal[i - k - 1][i - 1]) {

                dp[i] = Math.max(
                    dp[i],
                    dp[i - k - 1] + 1
                );
            }
        }

        return dp[n];
    }
}