class Solution {
    List<String> result;

    public String[] expand(String s) {
       result = new ArrayList<>(); 
       backtrack("", s, 0);
       String[] array = result.toArray(new String[result.size()]);
       return array;
    }

    private void backtrack(String cur, String s, int i) {
        if (i >= s.length()) {
            result.add(cur);
            return;
        }

        if (s.charAt(i) == '{') {
            i++;
            int j = i;
            while (s.charAt(j) != '}') {
                j++;
            }
            String[] options = s.substring(i, j).split(",");
            for (String option : options) {
                backtrack(cur + option, s, j + 1);
            }
        } else {
            backtrack(cur + s.substring(i, i + 1), s, i + 1);
        }

    }
}
