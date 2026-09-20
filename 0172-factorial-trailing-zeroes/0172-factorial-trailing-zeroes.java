class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        int i = 1;
        while(n>0){
            n/=Math.pow(5,i);
            ans+=n;
        }
        return ans;
    }
}