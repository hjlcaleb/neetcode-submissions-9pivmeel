class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int n : nums1) seen.add(n);

        for (int n : nums2) {
            if (seen.contains(n)) {
                seen.remove(n);
                result.add(n);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}