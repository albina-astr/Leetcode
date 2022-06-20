package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author Albina Gimaletdinova on 01/03/2022
 */
public class ValidParentheses {
    /**
     * O(n) time
     * O(1) space
     */
    public boolean isValid(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string must not be null!");
        }
        if (str.isEmpty()) {
            return true;
        }

        Deque<Character> s = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') s.push(ch);
            else if (ch == '[') s.push(ch);
            else if (ch == '{') s.push(ch);
            else if (ch == ')') {
                if (s.isEmpty()) return false;
                char openBracket = s.pop();
                if (openBracket != '(') return false;
            } else if (ch == '}') {
                if (s.isEmpty()) return false;
                char openBracket = s.pop();
                if (openBracket != '{') return false;
            } else if (ch == ']') {
                if (s.isEmpty()) return false;
                char openBracket = s.pop();
                if (openBracket != '[') return false;
            } else return false;
        }
        return s.isEmpty();
    }
}
