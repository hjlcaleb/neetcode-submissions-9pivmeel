/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allTimes = new ArrayList<>();
        for (List<Interval> s : schedule) {
            for (Interval i : s) {
                allTimes.add(i);
            }
        }

        allTimes.sort((a, b) -> Integer.compare(a.start, b.start));
        List<Interval> res = new ArrayList<>();
        int prevEnd = allTimes.get(0).end;
        for (int i = 1; i < allTimes.size(); i++) {
            if (allTimes.get(i).start > prevEnd) {
                res.add(new Interval(prevEnd, allTimes.get(i).start));
            }
            prevEnd = Math.max(prevEnd, allTimes.get(i).end);
        }
        return res;
    }
}
