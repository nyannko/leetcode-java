import java.util.LinkedList;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')'  && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
//        System.out.println(longestValidParentheses("(())"));
//        System.out.println(longestValidParentheses("()(()"));
//        System.out.println(longestValidParentheses(")()())"));
    }
}
