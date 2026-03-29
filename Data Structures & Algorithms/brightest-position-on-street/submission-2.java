class Solution {
    public int brightestPosition(int[][] lights) {
        Map<Integer, Integer> posToBrightness = new TreeMap<>();
        for (int[] light : lights) {
            int position = light[0];
            int range = light[1];
            int lower = position - range;
            int upper = position + range + 1;
            posToBrightness.put(lower, posToBrightness.getOrDefault(lower, 0) + 1);
            posToBrightness.put(upper, posToBrightness.getOrDefault(upper, 0) - 1);
        }

        int maxBrightness = Integer.MIN_VALUE;
        int resultantPosition = Integer.MIN_VALUE;
        int currentBrightness = 0;
        for (int position : posToBrightness.keySet()) {
            currentBrightness += posToBrightness.get(position);
            if (currentBrightness > maxBrightness) {
                maxBrightness = currentBrightness;
                resultantPosition = position;
            }
        } 
        return resultantPosition;
    }
}
