package lesson16;

public class NumberOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(iterative(7));
        System.out.println(dp(7));
    }

    public static int iterative(int n) {
        if (n < 2) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int i = 0; i <= n - 1; i++) {
            res += (iterative(i) * iterative(n - 1 - i));
        }
        return res;
    }

    public static int dp(int n) {
        if (n < 2) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }
        return arr[n];
    }
}
