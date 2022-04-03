package lesson11;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        String w = "ABCDABD";
        System.out.println(Arrays.toString(w.toCharArray()));
        System.out.println(Arrays.toString(getPartialMatchTable(w)));
        String s = "ABCEABABCDABD";
        System.out.println(getIndex(s, w));
    }

    // str1.length() >= str2.length
    public static int getIndex(final String s, final String w) {
        if (s == null || w == null || s.isEmpty() || w.isEmpty() || s.length() < w.length()) {
            return -1;
        }
        int x = 0;
        int y = 0;
        int[] t = getPartialMatchTable(w);
        while (x < s.length() && y < w.length()) {
            if (s.charAt(x) == w.charAt(y)) {
                x++;
                y++;
                // if (y == w.length()) {
                // return x-y;
                // }
            } else {
                if (t[y] == -1) {
                    x++;
                    y = 0;
                } else {
                    y = t[y];
                }
            }
        }
        // return -1;
        return y == w.length() ? x - y : -1; // when y == w.length, there is substring match and while loop exits, so
                                             // the return in while loop can be moved here
    }

    // change to use charArray instead of String
    private static int[] getPartialMatchTable(final String w) {
        int[] t = new int[w.length()];
        t[0] = -1;
        System.out.println(Arrays.toString(t));
        for (int i = 1; i < t.length; i++) {
            t[i] = getLongestPartialMatch(t, w, i);
        }
        return t;
    }

    // change to use charArray instead of String
    private static int getLongestPartialMatch(int[] t, final String w, final int i) {
        int res = 0;
        // String subString = w.substring(0, i);
        // for (int index = 1; index < subString.length(); index++) {
        // if (subString.substring(0, index).equals(subString.substring(i - index))) {
        // res = index;
        // }
        // }
        if (i > 1) {
            if (w.charAt(i - 1) == w.charAt(t[i - 1])) {
                res = t[i - 1] + 1;
            } else {
                res = getLongestPartialMatch(t, w, 1 + t[i - 1]);
            }
        }
        return res;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // index in next
        int cn = 0; // index to compare in ms, it has to start from 0, if there is a match then you increment cn by 1 (the increment can only be done by 1 at a time)
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
