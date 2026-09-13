class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> freqHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (int value : map.values()) {
            freqHeap.offer(value);
        }

        Queue<int[]> queue = new LinkedList<>(); //{remainingFreq , available time}
        int time = 0;

        while (!freqHeap.isEmpty() || !queue.isEmpty()) {

            time++;
            if (!freqHeap.isEmpty()) {
                int freq = freqHeap.poll();
                freq--;

                if(freq>0)queue.offer(new int[] {freq,time+n});
            }

            if(!queue.isEmpty() && time >= queue.peek()[1]){
                freqHeap.offer(queue.peek()[0]);
                queue.poll();
                
            }

          

        }
        return time;
    }

}