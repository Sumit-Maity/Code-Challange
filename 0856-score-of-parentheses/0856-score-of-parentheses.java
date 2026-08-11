import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(0);
            } else {
                int current = stack.pop();

                int score = (current == 0) ? 1 : 2 * current;

                stack.push(stack.pop() + score);
            }
        }
        return stack.pop();
    }
}