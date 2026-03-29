class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long squaredVal = (long) mid * mid;
            if (squaredVal == x) {
                return mid;
            } 
            if (squaredVal < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}