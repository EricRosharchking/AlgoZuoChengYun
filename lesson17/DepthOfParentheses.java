package lesson17;

import java.util.Arrays;

public class DepthOfParentheses {

    public static int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    arr[i] += 2;
                    if (i >= 2) {
                        arr[i] += arr[i - 2];
                    }
                } else {
                    int x = i - arr[i - 1] - 1;
                    if (arr[i - 1] > 0 && x >= 0 && s.charAt(x) == '(') {
                        arr[i] = 2 + arr[i - 1];
                    }
                    while (i - arr[i] > 0 && arr[i - arr[i]] > 0) {
                        arr[i] += arr[i - arr[i]];
                    }
                }
            }
            res = Math.max(res, arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }

    public static int sampleSolution(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] arr = new int[str.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                pre = i - arr[i - 1] - 1;
                if (pre >= 0 && str[pre] == '(') {
                    arr[i] = arr[i - 1] + 2 + (pre > 0 ? arr[pre - 1] : 0);
                }
            }
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
