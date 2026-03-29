class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            if(!map1.containsKey(s.substring(i, i+1))){
                map1.put(s.substring(i, i+1), 1);
            } else {
                map1.put(s.substring(i, i+1), map1.get(s.substring(i, i+1) + 1));
            }

            if(!map2.containsKey(t.substring(i, i+1))){
                map2.put(t.substring(i, i+1), 1);
            } else {
                map2.put(t.substring(i, i+1), map2.get(t.substring(i, i+1) + 1));
            }
        }

        for(String string: map1.keySet()){
            if(!map2.containsKey(string) || map1.get(string) != (map2.get(string))){
                return false;
            }
        }

        return true;
    }
}
