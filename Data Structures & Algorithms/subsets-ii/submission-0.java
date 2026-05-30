class Solution {
    private List<List<Integer>> result;
    private List<Integer> cur;
    private int[] nums;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        cur = new ArrayList<>();
        this.nums = nums;
        backtrack(0);
        return result;
    }

    private void backtrack(int i) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(i + 1);
        cur.remove(cur.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(i + 1);
    }
}
