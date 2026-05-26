class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            triangle.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle.get(i).add(1);
                } else {
                    triangle.get(i).add(triangle.get(i - 1).get(j - 1) 
                        + triangle.get(i - 1).get(j));
                }
            }
        }

        return triangle;
    }
}