class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        int globalCount = 0;
        for (int num : uniqueNums) {
            if (uniqueNums.contains(num - 1)) {
                continue;
            }  
            int localCount = 0;
            while (uniqueNums.contains(num + localCount)) {
                localCount += 1;
                globalCount = Math.max(globalCount, localCount);
            }
        }
        return globalCount;
    }
}
