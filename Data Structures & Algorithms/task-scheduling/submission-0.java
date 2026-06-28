class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[(int)task - 'A']++;
        }

        PriorityQueue<int[]> jobQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        Queue<int[]> idleQueue = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                jobQueue.add(new int[]{i, counts[i]});
            }    
        }

        int time = 0;
        while (!jobQueue.isEmpty() || !idleQueue.isEmpty()) {
            time++;
            if (!jobQueue.isEmpty()) {
                int[] cur = jobQueue.remove();
                cur[1]--;
                if (cur[1] > 0) {
                    idleQueue.add(new int[]{cur[0], cur[1], time + n});
                }
            }

            if (!idleQueue.isEmpty() && idleQueue.peek()[2] == time) {
                jobQueue.add(idleQueue.remove());
            }
        }

        return time;

    }
}
