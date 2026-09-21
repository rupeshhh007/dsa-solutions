class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        int[] dp = new int[k];
        for (int num : nums) {
            int[] next = new int[k];
            int value = num % k;
            next[value]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRemainder = (r * value) % k;
                    next[newRemainder] += dp[r];
                }
            }
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }
            dp = next;
        }
        return result;
    }
}
