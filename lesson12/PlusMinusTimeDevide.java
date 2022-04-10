package lesson12;

public class PlusMinusTimeDevide {
    // provide the arithmetics without using +-*/ signs at all

    public static int plus(int a, int b) {
        int xor = a;
        while (b != 0) {
            xor = a ^ b;
            b = (a & b) << 1;
            a = xor;
        }
        return xor;
    }

    public static int minus(int a, int b) {
        return plus(a, negetiveOf(b));
    }

    public static int negetiveOf(int x) {
        return plus(~x, 1);
    }

    public static int time(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = plus(res, a);
            }
            a <<= 1;
            // unsigned bitwise shift : >>>
            b >>>= 1;
        }
        return res;
    }

    public static int divide(int a, int b) {
        int res = 0;
        int x = a > 0 ? negetiveOf(a) : a;
        int y = b > 0 ? negetiveOf(b) : b;

        for (int i = 31; i >= 0; i = minus(i, 1)) {
            if (x >> i >= y) {
                x = minus(x, y << i);
                res |= (1 << i);
            }
        }
        return a > 0 ^ b > 0 ? negetiveOf(res) : res;
    }
}
