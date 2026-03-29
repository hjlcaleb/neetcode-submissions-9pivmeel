class Solution {
    public boolean isHappy(int n) {
        Set<Integer> found = new HashSet<>();
        int numDigits = 1;
        while (true) {
            if (n == 1) return true;
            if (found.contains(n)) break;
            found.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return false;
    }
}
