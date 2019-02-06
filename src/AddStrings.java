public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            int n1 = (i < 0) ? 0 : num1.charAt(i) - '0';
            int n2 = (j < 0) ? 0 : num2.charAt(j) - '0';
            int value = n1 + n2 + carry;
            sb.append(value % 10);
            carry = value / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
