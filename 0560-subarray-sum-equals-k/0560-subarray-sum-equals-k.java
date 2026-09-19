class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefix = 0;
        int ans = 0;

        for(int num : nums){
            prefix+=num;
            int needed = prefix-k;

            if(map.containsKey(needed)){
                ans+=map.get(needed);
            }

            map.put(prefix , map.getOrDefault(prefix,0)+1);

        }
        return ans;
    }
}