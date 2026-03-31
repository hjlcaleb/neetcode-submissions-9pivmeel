class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int difference = a + stack.peek();
                if (difference < 0) {
                    stack.pop();
                } else if (difference > 0) {
                    a = 0;
                } else {
                    a = 0;
                    stack.pop();
                }
            }
            if (a != 0) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i--;
        }
        return result;
    }
}