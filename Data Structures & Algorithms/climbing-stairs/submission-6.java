class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int step1 = 1;
        int step2 = 1;
        int total = 0;
        for (int i = 2; i <= n; i++) {
            total = step1 + step2;
            step1 = step2;
            step2 = total;
        }
        return total;
    }
}
