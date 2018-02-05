package lists;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by sergei.kostin on 1/12/18.
 */
public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        boolean valid[] = new boolean[s.length()];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (!stack.isEmpty()) {
                valid[stack.pop()] = valid[i] = true;
            }
        }

        return longest(valid);
    }

    private int longest(boolean[] valid) {
        int max = 0;
        int len = 0;

        for (boolean v : valid) {
            max = Math.max(max, len = v ? len + 1 : 0);
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "((((())(((()";
        LongestValidParenthesis lvp = new LongestValidParenthesis();
        System.out.println(lvp.longestValidParentheses( str));

        boolean[] arr = new boolean[4];
        arr[0] = arr[2] = true;
        System.out.println(Arrays.toString(arr));
    }
}
