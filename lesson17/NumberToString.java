package lesson17;

public class NumberToString {
    
    // 1-26 correspond to a-z.
    // "11" can be "aa" or "k"
    // give String s with only numbers
    // return the number of different strings it can be converted to

    public static int solution(int s) {
        char[] str = String.valueOf(s).toCharArray();

        return iteration(str, 0);
    }

    public static int iteration(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int res = iteration(str, index+1);
        if (index == str.length - 1) {
            return res;
        }
        if (((str[index] - '0') * 10 + str[index+1] - '0') < 27) {
            res += iteration(str, index+2);
        }
        return res;
    }

    public static int dynamicPlanning(int num) {
        if (num < 1) {
            return 0;
        }
        char[] str = String.valueOf(num).toCharArray();
        int n = str.length;
        int[] arr = new int[n+1];
        arr[n] = 1;
        arr[n-1] = str[n-1] == '0' ? 0 : 1;
        for (int i = n-2; i >= 0; i--) {
            if (str[i] == '0') {
                arr[i] = 0;
            } else {
                arr[i] = arr[i+1] + (((str[i] - '0')*10 + str[i+1] - '0') < 27 ? arr[i+2] : 0);
            }
        }
        return arr[0];
    }
}
