class Solution {
    public int reverse(int x) {
        // Handle the absolute minimum value because Math.abs(Integer.MIN_VALUE) overflows
        if (x == Integer.MIN_VALUE) return 0; 
        
        int sign = (x < 0) ? -1 : 1;
        String numStr = String.valueOf(Math.abs(x));
        
        // Reverse only the digits
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        
        // Use a try-catch block to handle 32-bit integer overflow safely
        try {
            return sign * Integer.parseInt(reversedStr);
        } catch (NumberFormatException e) {
            return 0; // Return 0 if the reversed number overflows
        }
    }
}
