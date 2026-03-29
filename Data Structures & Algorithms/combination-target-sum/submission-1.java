class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), nums, 0, target);
        return result;
    }

    private void dfs(int i, List<Integer> cur, int[] nums, int total, int target) {
        if (total == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (i >= nums.length || total > target) {
            return;
        }

        cur.add(nums[i]);
        dfs(i, cur, nums, total + nums[i], target);
        cur.remove(cur.size() - 1);
        
        dfs(i + 1, cur, nums, total, target);
    }
}
