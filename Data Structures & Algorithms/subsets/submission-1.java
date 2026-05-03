class Solution {
    private List<List<Integer>> result;
    private List<Integer> curSet;
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        curSet = new ArrayList<>();
        this.nums = nums;
        dfs(0, curSet);
        return result;
    }

    private void dfs(int i, List<Integer> cur) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(i + 1, cur);
        cur.remove(cur.size() - 1);
        dfs(i + 1, cur);
    }
}
