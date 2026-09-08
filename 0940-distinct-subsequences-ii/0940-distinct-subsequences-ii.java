class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] dp = new long[26];
        
        long total = 0;
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
            long add = (total + 1) % MOD;
            total = (total + add - dp[idx] + MOD) % MOD;
            dp[idx] = add;
        }
        
        return (int) total;
    }
}