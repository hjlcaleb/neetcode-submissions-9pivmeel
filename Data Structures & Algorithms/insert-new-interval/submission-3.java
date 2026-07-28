class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        boolean inserted = false;
        for (int i = 0; i < n; i++) {
            if (!inserted && newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                res.add(intervals[i]);
                inserted = true;
            } else if (inserted || newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        if (!inserted) res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }
}