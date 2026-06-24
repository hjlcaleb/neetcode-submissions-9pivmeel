class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> cardFreq = new TreeMap<>();
        for (int card : hand) {
            cardFreq.put(card, cardFreq.getOrDefault(card, 0) + 1);
        }

        for (int num : hand) {
            int start = num;
            while (cardFreq.getOrDefault(start - 1, 0) > 0) start--;
            while (start <= num) {
                while (cardFreq.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (cardFreq.getOrDefault(i, 0) == 0) return false;
                        cardFreq.put(i, cardFreq.get(i) - 1);
                    }
                }
                start++;
            }
        }

        return true;
    }
}
