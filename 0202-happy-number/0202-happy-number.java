class Solution {
    public boolean isHappy(int n) {
        int tortoise = n;
        int hare = getNext(n);
        
        // Loop until hare finds 1 or catches up with the tortoise (detecting a cycle)
        while (hare != 1 && tortoise != hare) {
            tortoise = getNext(tortoise);       // Moves 1 step
            hare = getNext(getNext(hare));     // Moves 2 steps
        }
        
        return hare == 1;
    }

    // Helper method to calculate the sum of the squares of digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}
