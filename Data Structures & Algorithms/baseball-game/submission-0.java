class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int a = scores.pop();
                int b = scores.peek();
                int sum = a + b;
                scores.push(a);
                scores.push(sum);
            } else if (op.equals("D")) {
                int doubledScore = scores.peek() * 2;
                scores.push(doubledScore);
            } else if (op.equals("C")) {
                scores.pop();
            } else {
                scores.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }
}