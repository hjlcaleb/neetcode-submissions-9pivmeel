class Solution {
    public int maxLength(int[] ribbons, int k) {
        int max = 0;
        for (int ribbon : ribbons) {
            max = Math.max(max, ribbon);
        }
        
        int answer = 0;
        int l = 1;
        int r = max;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(ribbons, k, mid)) {
                answer = Math.max(answer, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }

    private boolean isPossible(int[] ribbons, int k, int x) {
        int totalRibbons = 0;
        for (int i = 0; i < ribbons.length; i++) {
            totalRibbons += ribbons[i] / x;
        }

        return totalRibbons >= k;
    }
}
