class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int area = 0;

        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(height[l], maxLeft);
                area += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(height[r], maxRight);
                area += maxRight - height[r];
            }
        }
        return area;
    }
}
