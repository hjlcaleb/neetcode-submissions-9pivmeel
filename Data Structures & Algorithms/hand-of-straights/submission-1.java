class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> cardFreq = new TreeMap<>();
        for (int card : hand) {
            cardFreq.put(card, cardFreq.getOrDefault(card, 0) + 1);
        }

        for (int card : cardFreq.keySet()) {
            int count = cardFreq.get(card);
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int cur = card + i;
                    if (cardFreq.getOrDefault(cur, 0) == 0) return false;
                    cardFreq.put(cur, cardFreq.get(cur) - count);
                }
            }
        }

        return true;
    }
}
