class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;

        for (long k = 1; k * (k + 1) / 2 <= n; k++) {

            long remaining = n - k * (k - 1) / 2;

            if (remaining % k == 0) {
                ans++;
            }
        }

        return ans;
    }
}