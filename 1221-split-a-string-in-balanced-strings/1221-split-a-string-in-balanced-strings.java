class Solution {
    public int balancedStringSplit(String s) {
        int sum = 0;
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='L')sum--;
            else if(s.charAt(i)=='R')sum++;

            if(sum==0)ans++;
        }
        return ans;
    }
}