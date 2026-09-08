class Solution {
    public int totalSteps(int[] nums) {

        int maxSteps = 0;

        Stack<int[]> stack = new Stack<>();

        for(int i = nums.length-1; i>=0; i--){
            int currentSteps = 0;
         while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
               
                currentSteps = Math.max(currentSteps + 1, stack.peek()[1]);
                stack.pop();
            }
        maxSteps = Math.max(maxSteps,currentSteps);

        stack.push(new int[] {nums[i],currentSteps});
            
        }
        return maxSteps;
        
    }
}