class Solution {
    private int[] nums;
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        return divide(nums, 0, nums.length - 1);
    }

    private int[] divide(int[] array, int l, int r) {
        if (l == r) return array;

        int m = (l + r) / 2;
        divide(array, l, m);
        divide(array, m + 1, r);
        merge(array, l, m, r);
        return array;

    }

    private void merge(int[] array, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(array, l, m + 1);
        int[] right = Arrays.copyOfRange(array, m + 1, r + 1);
        int i = l;
        int j = 0;
        int k = 0;

        while (j < left.length && k < right.length) {
            if (left[j] <= right[k]) {
                array[i] = left[j++];
            } else {
                array[i] = right[k++];
            }
            i++;
        }

        while (j < left.length) {
            nums[i++] = left[j++];
        }
        
        while (k < right.length) {
            nums[i++] = right[k++];
        }
    }
}