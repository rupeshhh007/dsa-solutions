class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int n = nums.length;
        int maxSteps = 0;
        for(int i = n-1;i>=0;i--){
              int currentSteps = 0;
            while(!stack.isEmpty() && stack.peek()[0]<nums[i]){
                currentSteps = Math.max(currentSteps+1,stack.peek()[1]);
                stack.pop();
            }
             maxSteps = Math.max(maxSteps,currentSteps);
             stack.push(new int[] {nums[i],currentSteps});



        }
        return maxSteps;
        
    }
}