class Solution {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        // push all characters to stack   
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        // pop all characters off stack for each index in char[] s
        // LIFO property reverses order of characters
        int i = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            s[i++] = c;
        }
    }
}