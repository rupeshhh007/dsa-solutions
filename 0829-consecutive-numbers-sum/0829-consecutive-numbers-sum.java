class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        if(n==1) return 1;
        for (long k = 1; k * (k + 1) / 2 <= n; k++) {
            double result = n - k*(k-1)/2;
            result = result/k;
            if (result > 0 && result % 1 == 0)ans++;
        }
        return ans;
    }
}