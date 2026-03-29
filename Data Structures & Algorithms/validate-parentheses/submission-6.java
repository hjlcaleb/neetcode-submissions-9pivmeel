class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (closeToOpen.values().contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() 
                        || stack.pop() != closeToOpen.get(s.charAt(i))) {
                return false;
            } 
        }
        if (!stack.isEmpty()) { return false; }
        return true;
    }
}
