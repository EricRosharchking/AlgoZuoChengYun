package lesson1;

public class OneTimeOccurrance {
    
    // in an array of int, only one number occurred only once, the rest all occurred twice.
    // find the number that occurred only once.

    public static int getNumber(int[] arr) {
        int res = 0;
        if (arr == null || arr.length == 0) {
            return res;
        }
        if (arr.length < 2) {
            return arr[0];
        }

        for (int i: arr) {
            res = res ^ i;
        }
        return res;
    }

    // in an array of int, only two numbers occurred only once, the rest all occurred twice.
    // find the two numbers that occurred only once.

    public static int[] getNumbers(int[] arr) {
        int[] res = new int[2];
        if (arr == null || arr.length == 0) {
            return res;
        }
        if (arr.length < 3) {
            return arr;
        }

        int xor = 0;
        for (int i: arr) {
            xor = xor ^ i;
        }
        System.out.println(xor);
        int rightestOne = xor & ((~xor) + 1);
        System.out.println(rightestOne);
        int a = 0;
        for (int i: arr) {
            if ((i & rightestOne) == 0) {
                a = a ^ i;
            }
        }
        res[0] = a;
        res[1] = a ^ xor;
        return res;
    }
}
