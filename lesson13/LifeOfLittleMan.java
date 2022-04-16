package lesson13;

public class LifeOfLittleMan {

    public static String livelihood1(int M, int N, int a, int b, int K) {
        long lived = process1(M, N, a, b, K);
        long all = (long) Math.pow(4, K);
        long gcd = findGreatestCommonDenominator(lived, all);
        return String.valueOf((lived / gcd) + "/" + (all / gcd));
    }

    public static long process1(int M, int N, int x, int y, int steps) {
        if (x < 0 || x == M || y < 0 || y == N) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }
        return process1(M, N, x + 1, y, steps - 1) + process1(M, N, x - 1, y, steps - 1)
                + process1(M, N, x, y - 1, steps - 1) + process1(M, N, x, y + 1, steps - 1);
    }

    public static long findGreatestCommonDenominator(long a, long b) {
        return b == 0 ? a : findGreatestCommonDenominator(b, a % b);
    }
}
