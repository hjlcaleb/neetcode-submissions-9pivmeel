class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalArea = 0;

        while (l <= r) {
            if (leftMax <= rightMax) {
                if (leftMax - height[l] >= 0) {
                    totalArea += leftMax - height[l];
                }
                leftMax = Math.max(height[l], leftMax);
                height[l] = leftMax;
                l++;
            } else {
                if (rightMax - height[r] >= 0) {
                    totalArea += rightMax - height[r];
                }
                rightMax = Math.max(height[r], rightMax);
                height[r] = rightMax;
                r--;
            }
        }
        return totalArea;
    }
}
