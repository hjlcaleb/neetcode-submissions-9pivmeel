class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int startIndex = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pair = stack.pop();
                int index = pair[0];
                int height = pair[1];
                maxArea = Math.max(maxArea, height * (i - index));
                startIndex = index;
            }
            stack.push(new int[]{startIndex, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
