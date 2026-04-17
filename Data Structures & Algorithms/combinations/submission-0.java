class Solution {
    private List<List<Integer>> result;
    private int k;
    private int n;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        this.k = k;
        this.n = n;
        exploreCombos(1, new ArrayList<>());
        return result;
    }

    private void exploreCombos(int num, List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (num > n) {
            return;
        }

        current.add(num);
        exploreCombos(num + 1, current);
        current.remove(current.size() - 1);
        exploreCombos(num + 1, current);
    } 
}