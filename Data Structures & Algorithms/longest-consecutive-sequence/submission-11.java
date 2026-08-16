class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> candidates = new HashSet<>();
        int longest = 1;
        for (int n : nums) {
            candidates.add(n);
        }

        for (int n : candidates) {
            if (!candidates.contains(n - 1)) {
                int currentNum = n;
                int currentStreak = 1;

                while (candidates.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}
