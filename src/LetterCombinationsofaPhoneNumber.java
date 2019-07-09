import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    static String[] map = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        // check boundary
        if (digits == null || digits.length() == 0) return new ArrayList<>();

        // get keys
        char[] keys = digits.toCharArray();
        // get result
        List<String> res = new ArrayList<>();
        dfs(keys, res, "", 0);
        return res;
    }

    private static void dfs(char[] keys, List<String> res, String s, int index) {
        if (keys.length == index) {
            res.add(s);
            return;
        }
        char key = keys[index]; // 1 or 2
        String letters = map[key - '0']; // get letters
        for (int i = 0; i < letters.length(); i++) {
            // a convenient way to debug
            System.out.println(index + " use: " + letters.charAt(i) + " get:" + s + letters.charAt(i));
            dfs(keys, res, s + letters.charAt(i), index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
