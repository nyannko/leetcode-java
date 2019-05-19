import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SayNumbers {
    public static void main(String[] args) {
        String[] strings = {"000", "100", "001", "011", "111", "321", "1000", "1001", "000000", "000001", "001001", "1000000",
                 "22329192", "569045", "100000000000000", "12000450345000", "100, 000, 000, 000, 000", "100, 000, 000, 000, 00000"};
        for (String s : strings) {
//            String[] tokens = splitReverse(s, 3);
            String[] tokens = split(s, 3);
            String res = getString(tokens);
            System.out.println(Arrays.toString(tokens) + ": " + res);
        }
    }

    public static String getString(String[] tokens) {
        if (tokens.length > 5)
            return "fail";
        StringBuilder sb = new StringBuilder();
        String[] unit = {"", "thousand", "million", "billion", "trillion"};
        for (int i = tokens.length - 1; i >= 0 ; i--) {
            String token = convert(tokens[i]);
            if (!token.equals("zero")) {
                sb.insert(0, token + " " + unit[tokens.length - 1 - i] + " ");
            }
        }
        if (sb.toString().equals("")) {
           sb.append("zero");
        }
        return sb.toString();
    }

    public static String convert(String s) {
        int len = s.length();
        String res = "";
        if (len == 1) res = sayOne(s);
        else if (len == 2) res = sayTwo(s);
        else res = sayThree(s);
        return res;
    }

    public static String sayThree(String s) {
        String res = "";
        // start with zero
        if (s.charAt(0) == '0') {
            //start with zero end with 2 zeros
            if (s.charAt(1) == '0') {
                if (s.charAt(2) == '0') {
                    res = "zero";
                } else { // end with non-zero digit
                    res = sayOne(s.substring(2));
                }
            } else { // end with non-zero digits
                res = sayTwo(s.substring(1));
            }
        } else if (s.charAt(1) == '0' && s.charAt(2) == '0') { // start with 1-9, end with two zeros
            res = sayOne(s.substring(0, 1)) + " hundred";
        } else { // other cases
            res = sayOne(s.substring(0, 1)) + " hundred and " + sayTwo(s.substring(1));
        }
        return res;
    }

    private static String sayTwo(String s) {
        String res = "";
        if (s.charAt(0) == '0') res = sayOne(s.substring(1));
        else if (s.charAt(0) == '1') {
            switch (s.charAt(1)) {
                case '0': res = "ten"; break;
                case '1': res = "eleven"; break;
                case '2': res = "twelve"; break;
                case '3': res = "thirteen"; break;
                case '4': res = "fourteen"; break;
                case '5': res = "fifteen"; break;
                case '6': res = "sixteen"; break;
                case '7': res = "seventeen"; break;
                case '8': res = "eighteen"; break;
                case '9': res = "nineteen"; break;
            }
        } else {
            switch (s.charAt(0)) {
                case '2': res = "twenty"; break;
                case '3': res = "thirty"; break;
                case '4': res = "forty"; break;
                case '5': res = "fifty"; break;
                case '6': res = "sixty"; break;
                case '7': res = "seventy"; break;
                case '8': res = "eighty"; break;
                case '9': res = "ninety"; break;
            }
            if(s.charAt(1) != '0')
                res = res + "-" + sayOne(s.substring(1));
        }
        return res;
    }

    public static String sayOne(String s) {
        String res = "";
        switch (s.charAt(0)) {
            case '0': res = "zero"; break;
            case '1': res = "one"; break;
            case '2': res = "two"; break;
            case '3': res = "three"; break;
            case '4': res = "four"; break;
            case '5': res = "five"; break;
            case '6': res = "six"; break;
            case '7': res = "seven"; break;
            case '8': res = "eight"; break;
            case '9': res = "nine"; break;
        }
        return res;
    }

    // split from right to left
    public static String[] splitReverse(String s, int n) {
        s = s.replaceAll("[,\\s+]", "");
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

    public static String[] split(String s, int n) {
        s = s.replaceAll("[,\\s+]", "");
        List<String> list = new ArrayList<>();
        int i = s.length() - 3;
        while (i > 0) {
            list.add(s.substring(i, i + 3));
            i -= 3;
        }
        list.add(0, s.substring(0, i + 3));
        return list.toArray(new String[0]);
    }
}
