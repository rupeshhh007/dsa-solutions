class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxPrefix = new int[n];
        int[] minSuffix = new int[n];
        
        maxPrefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }
        
        minSuffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(minSuffix[i + 1], nums[i]);
        }
        
        for (int i = 0; i < n; i++) {
            if ((long) maxPrefix[i] - minSuffix[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}
