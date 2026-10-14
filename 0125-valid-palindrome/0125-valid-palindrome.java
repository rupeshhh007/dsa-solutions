class Solution {
    public boolean isPalindrome(String s) {
        String actual = "";
        for(int i = 0 ; i<s.length();i++){
            char ch = s.charAt(i);
            if(!Character.isLetterOrDigit(ch))continue;

            else{
                if (Character.isLetter(ch)) actual += Character.toLowerCase(ch);

                else actual+= ch;
            }


        }

        int start = 0;
        int end = actual.length()-1;

        System.out.println(actual);

        while(start<=end){
            if(actual.charAt(start)!=actual.charAt(end))return false;

            start++;
            end--;
        }
        return true;
    }
}