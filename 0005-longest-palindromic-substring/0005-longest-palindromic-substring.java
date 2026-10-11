class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0 ; i<s.length();i++){
            int l1 =  expandAroundCenter(s,i,i);
            int l2 = expandAroundCenter(s,i,i+1);

            int maxL = Math.max(l1,l2);
            int left = i - (maxL - 1) / 2;
            int right = i + maxL / 2;

            if(maxL > end-start+1){
                start = left;
                end = right;
            }
        }
        return s.substring(start,end+1);
    }

    public int expandAroundCenter(String s, int left,int right){
        while(left>=0 && right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}