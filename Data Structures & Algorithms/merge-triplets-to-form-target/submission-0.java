class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] candidate = new int[]{0, 0, 0};
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1]
                && triplets[i][2] <= target[2]) {
                
                candidate[0] = Math.max(candidate[0], triplets[i][0]);
                candidate[1] = Math.max(candidate[1], triplets[i][1]);
                candidate[2] = Math.max(candidate[2], triplets[i][2]);
            }
        }
        return target[0] == candidate[0] && target[1] == candidate[1]
            && target[2] == candidate[2];
    }
}
