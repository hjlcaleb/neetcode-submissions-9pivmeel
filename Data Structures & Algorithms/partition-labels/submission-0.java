class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeenIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastSeenIdx[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastSeenIdx[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
