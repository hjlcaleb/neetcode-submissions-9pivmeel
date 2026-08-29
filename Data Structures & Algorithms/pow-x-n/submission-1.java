class Solution {
    public double myPow(double x, int n) {
        double result = computePower(x, Math.abs(n));
        return (n >= 0) ? result : 1 / result;
    }

    private double computePower(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        double result = computePower(x, n / 2);
        result *= result;
        return (n % 2 == 0) ? result : x * result;
    }
}
