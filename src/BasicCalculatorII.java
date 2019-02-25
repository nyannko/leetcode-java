import java.util.LinkedList;

public class BasicCalculatorII {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+'; // the sign for the first number
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '-') stack.push(-num);
                else if (sign == '+') stack.push(num);
                else if (sign == '*') stack.push(stack.pop() * num);
                else  stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        int sum = 0;
        for (int n : stack) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        calculate("30+2*2");
        calculate("-30");
    }
}
