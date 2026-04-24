class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];
        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= curEnd) {
                curEnd = Math.max(curEnd, interval[1]);
            } else {
                mergedIntervals.add(new int[]{curStart, curEnd});
                curStart = interval[0];
                curEnd = interval[1];
            }
        }

        mergedIntervals.add(new int[]{curStart, curEnd});

        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = mergedIntervals.get(i);
        }
        return result;
    }
}
