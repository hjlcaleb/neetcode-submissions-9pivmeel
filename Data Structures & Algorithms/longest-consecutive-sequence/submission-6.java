class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            unique.add(n);
        }

        Map<Integer, Integer> endToStreak = new HashMap<>();
        int longest = 0;
        for (int n : nums) {
            if (!endToStreak.containsKey(n)) {
                endToStreak.put(n, 1);
                int num = n;
                while (unique.contains(num - 1)) {
                    endToStreak.put(n, endToStreak.get(n) + 1);
                    num--;
                }
                longest = Math.max(longest, endToStreak.get(n));
            }
        }
        return longest;
    }
}
