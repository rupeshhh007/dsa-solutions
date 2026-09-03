class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestOdd = Integer.MAX_VALUE;
        int smallestEven = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 != 0) {
                smallestOdd = Math.min(smallestOdd, num);
            } else {
                smallestEven = Math.min(smallestEven, num);
            }
        }

        // Case 1: If there are no odd numbers, it's already all even.
        if (smallestOdd == Integer.MAX_VALUE) return true;

        // Case 2: To make everything ODD, the smallest odd number 
        // must be strictly smaller than the smallest even number.
        if (smallestOdd < smallestEven) return true;

        // If neither is possible, return false
        return false;
    }
}
