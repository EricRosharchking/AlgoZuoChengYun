package lesson7;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestLexicography {
    static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }

    }

    public static String smallestLexicoString(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        String res = "";
        Arrays.sort(arr, new StringComparator());
        for (String str: arr) {
            res += str;
        }
        return res;
    }
}