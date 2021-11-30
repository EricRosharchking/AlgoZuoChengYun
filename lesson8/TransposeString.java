package lesson8;

public class TransposeString {
    
    public static void main(String[] str) {
        System.out.println(calculate("111".toCharArray(), 0));
    }

    public static int calculate(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }
        if (chars[i] == '1') {
            int res = calculate(chars, i+1);
            if (i+1 < chars.length) {
                res += calculate(chars, i+2);
            }
            return res;
        }
        if (chars[i] == '2') {
            int res = calculate(chars, i+1);
            if (i+1 < chars.length && chars[i+1] <= 6) {
                res += calculate(chars, i+2);
            }
            return res;
        }
        return calculate(chars, i+1);
    }
}
