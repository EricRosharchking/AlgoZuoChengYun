package lesson11;

import java.util.Arrays;

public class Manacher {

    public static void main(String[] args) {
        String s = "bananas";
        // "#a#b#b#a#"
        // "121252121"
       System.out.println(getLongestPalindromeLength(s));
    }

    public static int getLongestPalindromeLength(String s) {
        int[] radiusArray = radiusArray(s);
        // System.out.println(Arrays.toString(radiusArray));
        int res = 0;
        for (int i = 0; i < radiusArray.length; i++) {
            res = radiusArray[i] - 1 > res ? radiusArray[i] - 1 : res;
        }
        return res;
    }

    private static int[] radiusArray(String s) {
        char[] chars = insertIntoString(s).toCharArray();
        // System.out.println(Arrays.toString(chars));

        int[] pArr = new int[chars.length];
        for (int i = 0; i < pArr.length; i++) {
            pArr[i] = -1;
        }
        int R = -1;
        int C = -1;
        for (int i = 0; i < chars.length; i++) {
            // System.out.println(i + ", " + C + ", " + R);
            if (i >= R) {
                // brute force compare
                pArr[i] = getPalindromeRadius(chars, i, i+1);
                if (pArr[i] > 1) {
                    C = i;
                    R = i + pArr[i] - 1;
                }
            } else {
                int j = C - (i - C);
                int L = C - (R - C);
                // System.out.print(j + ", " + L + ": ");
                if (j - pArr[j] + 1> L) {
                    pArr[i] = pArr[j];
                } else if (j - pArr[j] + 1 < L) {
                    pArr[i] = R - i + 1;
                } else {
                    pArr[i] = getPalindromeRadius(chars, i, R+1);
                    if (pArr[i] + i > R) {
                    C = i;
                    R = i + pArr[i];
                    }
                }
            }
            // System.out.println(Arrays.toString(pArr));
            // System.out.println(i + ", " + C + ", " + R);
        }

        return pArr;
    }

    private static String insertIntoString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        return sb.toString();
    }

    // definition of method (arguments) was not clear, so there are overlapping boundaries that causes wrong result, also return result was defined wrongly
    /**
     * Check if there is a palindrome centered at centerIndex, start comparing from comparingIndex
     * @param chars the char sequence from the insertedString
     * @param centerIndex the center of the palindrome
     * @param compareIndex starting index of comparison, at lease one position to the right of @param centerIndex , or of the right-most index of a known palindrome
     * @return the palindrome radius centering the @param centerIndex the result is one if there is no palindrome, 2 if the palindrome is "#a#", etc.
     */
    private static int getPalindromeRadius(char[] chars, int centerIndex, int compareIndex) {
        // System.out.println("getPalindromeRadius: " + centerIndex+ ", " + compareIndex);
        int i = compareIndex;
        while (centerIndex - (i - centerIndex) >= 0 
                && i < chars.length && chars[i] == chars[centerIndex - (i - centerIndex)]) {
            // System.out.println(i - centerIndex);
            i++;
        }
        return i > compareIndex ? i - centerIndex : 1;
    }
}
