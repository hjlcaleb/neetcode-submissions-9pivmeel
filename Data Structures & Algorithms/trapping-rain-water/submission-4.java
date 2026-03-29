class Solution {
    public int trap(int[] height) {
        int[] maxHeights = new int[height.length];
        int maxLeft = 0;
        for (int i = 0; i < maxHeights.length; i++) {
            maxHeights[i] = maxLeft;
            maxLeft = Math.max(maxLeft, height[i]);
        }

        int maxRight = 0;
        for (int i = maxHeights.length - 1; i >= 0; i--) {
            maxHeights[i] = Math.min(maxRight, maxHeights[i]);
            maxRight = Math.max(maxRight, height[i]);
        }

        int area = 0;
        for (int i = 0; i < maxHeights.length; i++) {
            area += Math.max(maxHeights[i] - height[i], 0);
        }
        return area;
    }
}
