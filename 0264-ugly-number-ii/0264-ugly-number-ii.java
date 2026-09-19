import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        
        int p2 = 0, p3 = 0, p5 = 0;
        
        while (dp.size() < n) {
            int next2 = dp.get(p2) * 2;
            int next3 = dp.get(p3) * 3;
            int next5 = dp.get(p5) * 5;
            
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            dp.add(nextUgly);
            
            if (nextUgly == next2) p2++;
            if (nextUgly == next3) p3++;
            if (nextUgly == next5) p5++;
        }
        
        for (int a : dp) {
            System.out.print(a + ",");
        }
        System.out.println();
        
        return dp.get(n - 1);
    }
}
