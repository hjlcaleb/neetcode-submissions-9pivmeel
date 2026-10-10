class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (true) {
            if (n == 1) return true;
            if (seen.contains(n)) return false;
            seen.add(n);
            int cur = 0;
            while (n > 0) {
                cur += ((n % 10) * (n % 10));
                n /= 10;
            }
            n = cur;
        }
    }
}
