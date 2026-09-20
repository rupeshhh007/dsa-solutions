class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            System.out.print(ch+", ");
            int val = 26-(ch-97);
            val*=i+1;
            System.out.println(val+" ");
            res = res + val;

        }
        return res;
        
    }
}