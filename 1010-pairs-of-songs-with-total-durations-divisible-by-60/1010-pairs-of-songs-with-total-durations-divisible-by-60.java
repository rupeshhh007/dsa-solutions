class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // Map stores: Key = Remainder (0-59), Value = How many times we've seen it
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int t : time) {
            int remainder = t % 60;
            // If remainder is 20, we need 40. If remainder is 0, we need 0.
            int needed = (60 - remainder) % 60; 

            // If we have seen the needed remainder before, add its count to our answer
            if (map.containsKey(needed)) {
                ans += map.get(needed);
            }

            // Record the current remainder in the map
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return ans;
    }
}
