class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int charLength = 0;
        int i = 0;
        while (i < words.length) {
            if (charLength + line.size() + words[i].length() <= maxWidth) {
                line.add(words[i]);
                charLength += words[i].length();
                i++;
            } else {
                // complete line - pack words with spaces
                int extraSpaces = maxWidth - charLength;
                int availableGaps = Math.max(line.size() - 1, 1);
                int spacesPerGap = extraSpaces / availableGaps;
                int remainingSpaces = extraSpaces % availableGaps;

                for (int j = 0; j < availableGaps; j++) {
                    line.set(j, line.get(j).concat(" ".repeat(spacesPerGap)));
                    if (remainingSpaces > 0) {
                        line.set(j, line.get(j).concat(" "));
                        remainingSpaces--;
                    }
                }
                result.add(String.join("", line));
                line.clear();
                charLength = 0;
            }
        }
        // handle last line
        String lastString = String.join(" ", line);
        int remainingSpaces = maxWidth - lastString.length();
        result.add(lastString.concat(" ".repeat(remainingSpaces)));
        return result;
    }
}