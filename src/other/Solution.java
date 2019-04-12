package other;

import java.util.Arrays;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = fix(sc.nextLine());
            list.add(s);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static String fix(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length() - 2; i++) {
            int j = i + 1, k = i + 2;
            while (k  < sb.length() && sb.charAt(i) == sb.charAt(j) && sb.charAt(i) == sb.charAt(k)) {
                sb.deleteCharAt(k);
            }
            while (k + 1 < sb.length() && sb.charAt(i) == sb.charAt(j) && sb.charAt(j) != sb.charAt(k) && sb.charAt(k) == sb.charAt(k + 1)) {
                sb.deleteCharAt(k);
            }
        }
        return sb.toString();
    }
}
