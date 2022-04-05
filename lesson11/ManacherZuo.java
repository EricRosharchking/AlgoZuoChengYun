package lesson11;

public class ManacherZuo {
    

    public static int maxLcpsLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1; // center index
        int R = -1; // right most index of palindrome plus 1
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != str.length; i++) {

            //pArr[i] 至少是多少（可以跳过不用一一比对的长度）
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //如果可以跳过的位置之后还可以有回文 则增加pArr[i]
            while ( i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i-pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            //更新R和C
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }

            max = Math.max(max, pArr[i]);
        }

        return max - 1;
    }

    private static char[] manacherString(String s) {
        char[] charArr = s.toCharArray();
        char[] res = new char[charArr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
}
