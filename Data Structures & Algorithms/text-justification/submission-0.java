class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int charLength = 0;
        int i = 0;

        while (i < words.length) {
            // if the current word can fit on the line
            if (charLength + line.size() + words[i].length() <= maxWidth) {
                charLength += words[i].length();
                line.add(words[i]);
                i++;
            } else {
                // line complete, insert spaces, add to result
                int extraSpaces = maxWidth - charLength;
                int remainder = extraSpaces % Math.max(1, line.size() - 1);
                int spacePerWord = extraSpaces / Math.max(1, line.size() - 1);

                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
                    line.set(j, line.get(j).concat(" ".repeat(spacePerWord)));
                    if (remainder > 0) {
                        line.set(j, line.get(j).concat(" "));
                        remainder--;
                    }
                }
                result.add(String.join("", line));
                line.clear();
                charLength = 0;
            }
        }
        // handle last line
        String lastLine = String.join(" ", line);
        int trail_space = maxWidth - lastLine.length();
        result.add(lastLine.concat(" ".repeat(trail_space)));

        return result;        
    }
}