class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];
        if (i < n) {
            start = Math.min(intervals[i][0], newInterval[0]);
        }
        
        while (i < n && intervals[i][0] <= newInterval[1]) {
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        result.add(new int[]{start, end});
        
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        i = 0;
        int[][] res = new int[result.size()][2];
        for (int[] interval : result) {
            res[i++] = interval;
        }
        return res;
    }
}
