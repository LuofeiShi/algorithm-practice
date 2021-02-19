class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> dic = new HashMap<>();
        dic.put('(', ')');
        dic.put('[', ']');
        dic.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (dic.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (dic.get(left) != cur) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
