class Solution {
    private int[][] jobs;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new int[startTime.length][3];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[jobs.length + 1];
        dp[jobs.length] = 0;
        for (int i = jobs.length - 1; i >= 0; i--) {
            int[] curJob = jobs[i];
            int nextValidIdx = nextAvailableJob(curJob, i);
            if (i + nextValidIdx + 1 >= jobs.length || nextValidIdx == -1) {
                dp[i] = Math.max(curJob[2], dp[i + 1]);
            } else {
                dp[i] = Math.max(curJob[2] + dp[i + nextValidIdx + 1], dp[i + 1]);
            }
        }
        return dp[0];
    }

    private int nextAvailableJob(int[] curJob, int start) {
        int count = 0;
        for (int i = start + 1; i < jobs.length; i++) {
            int[] nextJob = jobs[i];
            if (nextJob[0] < curJob[1]) {
                count++;
            } else {
                return count;
            }
        }
        return -1;
    }
}