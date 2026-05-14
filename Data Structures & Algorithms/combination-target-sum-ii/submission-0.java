class Solution {
    private int[] candidates;
    private int target;
    private List<List<Integer>> result;
    private List<Integer> curCombo;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        result = new ArrayList<>();
        curCombo = new ArrayList<>();
        uniqueCombos(0, 0);
        return result;
    }

    private void uniqueCombos(int i, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(curCombo));
            return;
        }

        if (i >= candidates.length || sum > target) {
            return;
        }

        curCombo.add(candidates[i]);
        uniqueCombos(i + 1, sum + candidates[i]);
        curCombo.remove(curCombo.size() - 1);
        while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
            i++;
        }
        uniqueCombos(i + 1, sum);
        
    }
}
