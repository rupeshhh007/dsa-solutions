import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int currentMin = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
            
            if (i > 0) {
                currentMin = minLen[i - 1];
            }
            
            if (map.containsKey(sum - target)) {
                int startIdx = map.get(sum - target);
                int len = i - startIdx;
                
                if (startIdx >= 0 && minLen[startIdx] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minLen[startIdx]);
                }
                
                currentMin = Math.min(currentMin, len);
            }
            
            minLen[i] = currentMin;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
