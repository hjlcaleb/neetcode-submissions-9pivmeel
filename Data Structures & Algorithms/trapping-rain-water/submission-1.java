class Solution {
    public int trap(int[] height) {
        int totalArea = 0;
        int[] heightLimit = new int[height.length];

        // find max height to the left
        int maxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            heightLimit[i] = maxLeft;
            maxLeft = Math.max(height[i], maxLeft);
        }

        // find max height to the right, and compare with max height to left (find limiting height)
        int maxRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            heightLimit[i] = Math.min(heightLimit[i], maxRight);
            maxRight = Math.max(height[i], maxRight);
        }

        // compute total possible area: heightLimit[i] - height[i]
        for (int i = 0; i < heightLimit.length; i++) {
            int sum = heightLimit[i] - height[i];
            if (sum <= 0) continue;
            totalArea += sum;
        }

        return totalArea;
    }
}
