import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitNumber {
    // split from right to left
    public static String[] splitReserve(String s, int n) {
        List<String> list = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i = i - n) {
            StringBuilder sb = new StringBuilder();
            int j = i;
            while (j >= 0 && j > i - n) {
                sb.insert(0, s.charAt(j));
                j--;
            }
            list.add(0, sb.toString());
        }
        return list.toArray(new String[0]);
    }

    // split from left to right
    public static String[] split(String s, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i = i + n) {
            StringBuilder sb = new StringBuilder();
            int j = i;
            while (j < s.length() && j < i + n) {
                sb.append(s.charAt(j));
                j++;
            }
            list.add(sb.toString());
        }
        return list.toArray(new String[0]);
    }

    public static String[] split2(String s, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i += n) {
            if (i + n < s.length()) // check the boundary
                list.add(s.substring(i, i + n));
            else
                list.add(s.substring(i));
        }
        return list.toArray(new String[0]);
    }
}
