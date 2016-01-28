package Google;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by xyunpeng on 1/27/16.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if (s.charAt(i) != map.get(t)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
