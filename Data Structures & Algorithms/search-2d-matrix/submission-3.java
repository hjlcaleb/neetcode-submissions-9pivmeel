class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length - 1;
        int mid = 0;
        while (top <= bot) {
            mid = (top + bot) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                break;
            } else if (target > matrix[mid][matrix[0].length - 1]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bot = mid - 1;
            }
        }
        if (top > bot) return false;

        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int center = (left + right) / 2;
            if (target > matrix[mid][center]) {
                left = center + 1;
            } else if (target < matrix[mid][center]) {
                right = center - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
