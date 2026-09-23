class Solution {
    public int trap(int[] height) {
        int[] maxHeights = new int[height.length];
        int maxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            maxHeights[i] = maxLeft;
            maxLeft = Math.max(height[i], maxLeft);
        }

        int maxRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxHeights[i] = Math.min(maxHeights[i], maxRight);
            maxRight = Math.max(height[i], maxRight);
        }

        int waterAmt = 0;
        for (int i = 0; i < height.length; i++) {
            waterAmt += Math.max(maxHeights[i] - height[i], 0);
        }

        return waterAmt;
    }
}
