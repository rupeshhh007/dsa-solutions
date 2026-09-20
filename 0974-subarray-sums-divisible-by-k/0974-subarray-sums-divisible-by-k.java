class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int rem = 0;
        int prefix =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;

        for(int num:nums){
            prefix+=num;
            rem = (prefix % k + k) % k;
            if(map.containsKey(rem)) ans+=map.get(rem);

           
            map.put(rem,map.getOrDefault(rem,0)+1);

        }
        return ans;
        
    }
}