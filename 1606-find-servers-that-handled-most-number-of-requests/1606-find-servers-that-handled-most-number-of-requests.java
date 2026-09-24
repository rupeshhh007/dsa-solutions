class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();

        for(int i = 0; i<k; i++){
            available.add(i);
        }

        PriorityQueue<long[]>busy = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));

         int[] count = new int[k];

         for(int i = 0; i<arrival.length;i++){
            long currTime = arrival[i];

            while(!busy.isEmpty() && busy.peek()[0] <= currTime){
                long[] finished = busy.poll();
                int server = (int)finished[1];
                available.add(server);
            }

            if(available.isEmpty())continue;

            int preferred = i%k;
            Integer server = available.ceiling(preferred);

             if (server == null) {
                server = available.first();
            }

            available.remove(server);
             long finishTime =
                (long) arrival[i] + load[i];

            busy.offer(new long[]{
                finishTime,
                server
            });
            count[server]++;




         }

         int maxRequests = 0;
         for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }
         List<Integer> ans = new ArrayList<>();
         for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                ans.add(i);
            }
        }
        return ans;


    }
}