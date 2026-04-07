class Solution {
    private int[][] intervals;
    private int[] cache;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        intervals = new int[n][3];
        cache = new int[n];
        Arrays.fill(cache, -1);

        for (int i = 0; i < n; i++) {
            intervals[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        return dfs(0);
    }

    private int dfs(int i) {
        if (i == intervals.length) {
            return 0;
        }

        if (cache[i] != -1) {
            return cache[i];
        }

        int res = dfs(i + 1);
        int left = i + 1;
        int right = intervals.length;
        int j = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] >= intervals[i][1]) {
                j = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        cache[i] = Math.max(res, intervals[i][2] + dfs(j));
        return cache[i];
    }
}