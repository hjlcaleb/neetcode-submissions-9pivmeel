class Solution {
    private int[] nums;
    private boolean[] chosen;
    private List<Integer> cur;
    private List<List<Integer>> result;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        chosen = new boolean[nums.length];
        cur = new ArrayList<>();
        result = new ArrayList<>();
        backtrack(cur);
        return result;
    }

    private void backtrack(List<Integer> cur) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < chosen.length; i++) {
            if (!chosen[i]) {
                chosen[i] = true;
                cur.add(nums[i]);
                backtrack(cur);
                cur.remove(cur.size() - 1);
                chosen[i] = false;
            }
        }

        

    }
}
