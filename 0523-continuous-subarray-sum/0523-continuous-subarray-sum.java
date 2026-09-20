class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    
         int rem = 0;
        int prefix =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1); 
        int ans = 0;

        for(int i = 0 ; i<nums.length;i++){
            prefix+=nums[i];
            rem = (prefix % k + k) % k;
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                   return true;
                }
            }
           
            else map.put(rem,i);

        
    }
     return false;
    }
}